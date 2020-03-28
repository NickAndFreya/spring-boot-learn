/**
 *
 */
package com.freya.nc.netcdf.nctool;

import java.util.List;

/**
 * 站点数据转格点数据的工具
 * @author chengpiny
 */
public class GridDataUtil {
    private double latBegin;
    private double latEnd;
    private double lonBegin;
    private double lonEnd;
    private int latRange;
    private int lonRange;
    private int neighborPoint = 8;

    public GridDataUtil(double latBegin, double latEnd, double lonBegin,
                        double lonEnd, int latRange, int lonRange, int neighborPoint) {
        this.latBegin = latBegin;
        this.latEnd = latEnd;
        this.lonBegin = lonBegin;
        this.lonEnd = lonEnd;
        this.latRange = latRange;
        this.lonRange = lonRange;
        this.neighborPoint = neighborPoint;
    }

    public double[][] gridDataBuild(List<double[]> discrete, double undefData) {
        double[][] gridData = null;
        try {

            double[][] discreteData = new double[discrete.size()][3];
            for (int i = 0; i < discrete.size(); i++) {
                discreteData[i][0] = discrete.get(i)[0];
                discreteData[i][1] = discrete.get(i)[1];
                discreteData[i][2] = discrete.get(i)[2];
            }
            double[] X = new double[this.lonRange];
            double[] Y = new double[this.latRange];
            Interpolate.createGridXY_Num(this.lonBegin, this.latBegin, this.lonEnd, this.latEnd, X, Y);
            gridData = Interpolate.interpolation_IDW_Neighbor(discreteData, X, Y,
                    this.neighborPoint, undefData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return gridData;
    }
}
