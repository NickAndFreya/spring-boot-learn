package com.freya.nc.netcdf.nctool;

import ucar.nc2.ncml.NcMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 通过NCML创建nc文件的方法
 *
 * @author chengpiny
 */
public class CreateNCWithNCML {
    public void create(String ncmlFile, String ncFile) {
        try {
            NcMLReader.writeNcMLToFile(new FileInputStream(new File(ncmlFile)), ncFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateNCWithNCML util = new CreateNCWithNCML();
        util.create("E:\\ncmltemp\\rainfall05.ncml","E:\\ncmltemp\\rain05.nc");
    }

}
