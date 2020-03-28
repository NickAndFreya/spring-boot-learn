package com.freya.nc.common.ncutil;

/**
 * 数据转换工具
 *
 * @author chengpiny
 */
public class ArrayTransferUtil {

    /**
     * 二维数组转一维数组
     */
    public static double[] _2DT1D(double[][] data) {
        double[] result;
        int len = 0;
        for (double[] d : data) {
            len += d.length;
        }
        result = new double[len];
        int index = 0;
        for (double[] arr : data) {
            for (double element : arr) {
                result[index++] = element;
            }
        }
        return result;
    }

}
