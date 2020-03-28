package com.freya.nc.netcdf.nctool;

import com.freya.nc.common.ncutil.ArrayTransferUtil;
import com.freya.nc.common.ncutil.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ucar.ma2.ArrayDouble;
import ucar.ma2.Index;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFileWriter;
import ucar.nc2.Variable;

import java.io.IOException;

/**
 * @author chengpiny
 * 写入数据到nc文件的方法
 */
@Slf4j
public class WriteData24DNetCDF {

	public static boolean write(double[][] datas, String fileName, String varName) throws IOException {
		NetcdfFileWriter ncfile = null;
		try {
			ncfile = NetcdfFileWriter.openExisting(fileName);
			Variable var = ncfile.findVariable(varName);
			if (var == null) {
				log.error("变量\"" + varName + "\":{}", "不存在，请检查入参！");
				return false;
			}
			/** 1:选择的时次层数，1:选择的层级层数；datas[0].length:经度维数;datas.length:纬度维数*/
			int[] _selectdims = new int[]{1, 1, datas.length, datas[0].length};
			ArrayDouble ad = new ArrayDouble.D4(_selectdims[0], _selectdims[1], _selectdims[2], _selectdims[3]);
			int timeLevel = TimeUtil.getTimeLevel();
			log.info("当前时次:{}", timeLevel);
			/**timeLevel:写入的时次*/
			int[] startdims = new int[]{timeLevel, 0, 0, 0};
			int i, j;
			Index ima = ad.getIndex();
			//二维格点数据转为一维格点数据
			double[] data = ArrayTransferUtil._2DT1D(datas);
			for (i = 0; i < _selectdims[2]; i++) {
				for (j = 0; j < _selectdims[3]; j++) {
					ad.setDouble(ima.set(0, 0, i, j), data[i * _selectdims[3] + j]);
				}
			}
			ncfile.write(var, startdims, ad);
			ncfile.flush();
		} catch (IOException e) {
			log.error("数据写入失败:{}", e.getMessage());
			e.printStackTrace();
		} catch (InvalidRangeException e) {
			log.error("数据写入失败:{}", e.getMessage());
			e.printStackTrace();
		} finally {
			ncfile.close();
		}
		return true;
	}
}
