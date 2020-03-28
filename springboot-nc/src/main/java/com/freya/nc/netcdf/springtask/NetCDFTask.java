package com.freya.nc.netcdf.springtask;

import com.freya.nc.common.constant.Constant;
import com.freya.nc.common.ncutil.*;
import com.freya.nc.netcdf.nctool.CreateNCWithNCML;
import com.freya.nc.netcdf.nctool.GridDataUtil;
import com.freya.nc.netcdf.nctool.WriteData24DNetCDF;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class NetCDFTask {
	@Autowired
	private FilePathWrap filePathWrap;

	public void create4DNetCDF() {
		long start = System.currentTimeMillis();
		String path = filePathWrap.getPath();
		String filePath1h = path + "rain1h.nc";
		String filePath2h = path + "rain2h.nc";
		String filePath3h = path + "rain3h.nc";
		CreateNCWithNCML ncfile = new CreateNCWithNCML();
		String ncmlPath = filePathWrap.getNCMLPath();
		SimpleXmlUtil.setValue2ElementAttr(ncmlPath, TimeUtil.getTimeUnit());
		try {
			if (!new File(filePath1h).exists() || !new File(filePath2h).exists()
					|| !new File(filePath3h).exists()) {
				ncfile.create(filePathWrap.getNCMLPath(), filePath1h);
				ncfile.create(filePathWrap.getNCMLPath(), filePath2h);
				ncfile.create(filePathWrap.getNCMLPath(), filePath3h);
			} else {
				log.info("文件已存在!");
			}
		} catch (Exception e) {
			log.error("创建文件失败:{}", e.getMessage());
			e.printStackTrace();
		} finally {
			long end = System.currentTimeMillis();
			log.info("创建文件耗时:{}", (end - start) / 1000 + "秒");
		}
	}

	public void write4DNetCDF() throws Exception {
		long start = System.currentTimeMillis();
		String path = filePathWrap.getPath();
		String filepath1h = path + "rain1h.nc";
		String filepath2h = path + "rain2h.nc";
		String filepath3h = path + "rain3h.nc";
		if (!new File(filepath1h).exists() || !new File(filepath2h).exists() ||
				!new File(filepath3h).exists()) {
			this.create4DNetCDF();
		}
		String UTCtime = DateUtil.getUTCtime(new Date());
		Connection connection = null;
		List<double[]> discreteData1h = new ArrayList<double[]>();
		List<double[]> discreteData2h = new ArrayList<double[]>();
		List<double[]> discreteData3h = new ArrayList<double[]>();
		try {
			double latBegin = Constant.Meteorology.LAT_BEGIN.getValue();
			double latEnd = Constant.Meteorology.LAT_END.getValue();
			double lonBegin = Constant.Meteorology.LON_BEGIN.getValue();
			double lonEnd = Constant.Meteorology.LON_END.getValue();
			int latDims = (int) Constant.Meteorology.LAT_DIMS.getValue();//width
			int lonDims = (int) Constant.Meteorology.LON_DIMS.getValue();//height
			int neighborPoint = (int) Constant.Meteorology.NEIGHBOR_POINT.getValue();
			GridDataUtil util = new GridDataUtil(latBegin, latEnd, lonBegin, lonEnd, latDims, lonDims, neighborPoint);
			connection = ODPSUtil.getConnection();
			String sql = "select site,la,lo,rain_future_1h,rain_future_2h,rain_future_3h from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + ";";
			PreparedStatement psmt = connection.prepareStatement(sql);
			ResultSet res = psmt.executeQuery();
			while (res.next()) {
				double[] data1h = new double[3];
				data1h[0] = res.getDouble("lo");
				data1h[1] = res.getDouble("la");
				data1h[2] = res.getDouble("rain_future_1h");
				discreteData1h.add(data1h);
				double[] data2h = new double[3];
				data2h[0] = res.getDouble("lo");
				data2h[1] = res.getDouble("la");
				data2h[2] = res.getDouble("rain_future_2h");
				discreteData2h.add(data2h);
				double[] data3h = new double[3];
				data3h[0] = res.getDouble("lo");
				data3h[1] = res.getDouble("la");
				data3h[2] = res.getDouble("rain_future_3h");
				discreteData3h.add(data3h);
			}
			double[][] gridData1h = util.gridDataBuild(discreteData1h, 999.0d);
			double[][] gridData2h = util.gridDataBuild(discreteData2h, 999.0d);
			double[][] gridData3h = util.gridDataBuild(discreteData3h, 999.0d);

			WriteData24DNetCDF.write(gridData1h, filepath1h, "rainfall");
			WriteData24DNetCDF.write(gridData2h, filepath2h, "rainfall");
			WriteData24DNetCDF.write(gridData3h, filepath3h, "rainfall");
		} catch (Exception e) {
			log.error("write nctool fail:{}", e.getMessage());
			e.printStackTrace();
		} finally {
			ODPSUtil.close(connection);
			long end = System.currentTimeMillis();
			log.info("数据写入耗时:{}", (end - start) / 1000 + "秒");
		}

	}

}
