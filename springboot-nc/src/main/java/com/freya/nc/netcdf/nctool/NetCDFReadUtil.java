package com.freya.nc.netcdf.nctool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.io.IOException;

/**
 * nc文件读取工具
 *
 * @author chengpiny
 */
public class NetCDFReadUtil {
    private static final Logger logger = LoggerFactory.getLogger(NetCDFReadUtil.class);

    public static Object readNetcdfData4D(String filename, String varname, int[] _selectedDims, int[] _startDims) {
        NetcdfFile netcdfFile = null;
        Variable variable = null;
        try {
            netcdfFile = NetcdfFile.open(filename);
            variable = netcdfFile.findVariable(varname);
            if (variable == null) {
                logger.error("Variable {} not found! {} ", varname, filename);
                return null;
            }
            int[] startDims = new int[]{_startDims[0], _startDims[1], _startDims[2], _startDims[3]};
            int[] selectDims = new int[]{_selectedDims[0], _selectedDims[1], _selectedDims[2], _selectedDims[3]};
            Object data = variable.read(startDims, selectDims).get1DJavaArray(double.class);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidRangeException e) {
            e.printStackTrace();
        } finally {
            try {
                netcdfFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
