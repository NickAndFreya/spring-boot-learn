package com.freya.nc.common.ncutil;

import com.freya.nc.common.constant.Constant;
import com.freya.nc.netcdf.config.FilePathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 文件路径包装
 *
 * @author chengpiny
 */
@Component
public class FilePathWrap {
    @Autowired
    private FilePathConfig filePathConfig;

    public String getPath() {
        File file = null;
        String linuxpath = filePathConfig.getPath().getLinux();
        if (!linuxpath.endsWith(File.separator)) {
            linuxpath += File.separator + TimeUtil.getMonthWithYear();
        } else {
            linuxpath += TimeUtil.getMonthWithYear();
        }
        file = new File(linuxpath);
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        String filePath = file.getPath();
        if (filePath != null && !filePath.endsWith(File.separator)) {
            filePath += File.separator;
        }
        return filePath;
    }

    public String getNCMLPath() {
        File file = null;
        String linuxpath = filePathConfig.getPath().getNcmllin();
        if (!linuxpath.endsWith(File.separator)) {
            linuxpath += File.separator;
        }
        file = new File(linuxpath);
        String filePath = file.getPath();
        if (filePath != null && !filePath.endsWith(File.separator)) {
            filePath += File.separator;
        }
        switch (TimeUtil.getMonth()) {
            case 1:
                filePath += Constant.NCMLTemp.JAN.getValue();
                break;
            case 2:
                boolean leap = TimeUtil.isLeapYear();
                if (!leap) {
                    filePath += Constant.NCMLTemp.FEB_NOLEAP.getValue();
                } else {
                    filePath += Constant.NCMLTemp.FEB_LEAP.getValue();
                }
                break;
            case 3:
                filePath += Constant.NCMLTemp.MAR.getValue();
                break;
            case 4:
                filePath += Constant.NCMLTemp.APR.getValue();
                break;
            case 5:
                filePath += Constant.NCMLTemp.MAY.getValue();
                break;
            case 6:
                filePath += Constant.NCMLTemp.JUNE.getValue();
                break;
            case 7:
                filePath += Constant.NCMLTemp.JULY.getValue();
                break;
            case 8:
                filePath += Constant.NCMLTemp.AUG.getValue();
                break;
            case 9:
                filePath += Constant.NCMLTemp.SEP.getValue();
                break;
            case 10:
                filePath += Constant.NCMLTemp.OCT.getValue();
                break;
            case 11:
                filePath += Constant.NCMLTemp.NOV.getValue();
                break;
            case 12:
                filePath += Constant.NCMLTemp.DEC.getValue();
                break;
        }
        return filePath;
    }
}
