/**
 * Longshine.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.netcdf.nctool;

/**
 * @author chengpiny
 * @version $Id: Interpolate $$
 */
public class Interpolate {
    /**
     * Create grid X/Y coordinate
     *
     * @param Xlb X left bottom
     * @param Ylb Y left bottom
     * @param Xrt X right top
     * @param Yrt Y right top
     * @param X   X coordinate
     * @param Y   Y coordinate
     */
    public static void createGridXY_Num(double Xlb, double Ylb, double Xrt, double Yrt, double[] X, double[] Y) {
        int Xnum = X.length;
        int Ynum = Y.length;
        double XDelt = (Xrt - Xlb) / Xnum;
        double YDelt = (Yrt - Ylb) / Ynum;
        for (int i = 0; i < Xnum; i++) {
            X[i] = (Xlb + i * XDelt);
        }
        for (int i = 0; i < Ynum; i++) {
            Y[i] = (Ylb + i * YDelt);
        }
    }

    /**
     * Interpolation with IDW neighbor method
     *
     * @param SCoords                  discrete data array
     * @param X                        grid X array
     * @param Y                        grid Y array
     * @param NumberOfNearestNeighbors number of nearest neighbors
     * @return grid data
     */
    public static double[][] interpolation_IDW_Neighbor(double[][] SCoords, double[] X, double[] Y,
                                                        int NumberOfNearestNeighbors) {
        int rowNum, colNum, pNum;
        colNum = X.length;
        rowNum = Y.length;
        pNum = SCoords.length;
        double[][] GCoords = new double[rowNum][colNum];
        int i, j, p, l, aP;
        double w, SV, SW, aMin;
        int points;
        points = NumberOfNearestNeighbors;
        Object[][] NW = new Object[1][points];

        //---- Do interpolation
        for (i = 0; i < rowNum; i++) {
            for (j = 0; j < colNum; j++) {
                GCoords[i][j] = -999.0;
                SV = 0;
                SW = 0;
                for (p = 0; p < points; p++) {
                    if (X[j] == SCoords[p][0] && Y[i] == SCoords[p][1]) {
                        GCoords[i][j] = SCoords[p][2];
                        break;
                    } else {
                        w = 1 / (Math.pow(X[j] - SCoords[p][0], 2) + Math.pow(Y[i] - SCoords[p][1], 2));
                        NW[0][p] = w;
                        NW[1][p] = p;
                    }
                }
                if (GCoords[i][j] == -999.0) {
                    for (p = points; p < pNum; p++) {
                        if (Math.pow(X[j] - SCoords[p][0], 2) + Math.pow(Y[i] - SCoords[p][1], 2) == 0) {
                            GCoords[i][j] = SCoords[p][2];
                            break;
                        } else {
                            w = 1 / (Math.pow(X[j] - SCoords[p][0], 2) + Math.pow(Y[i] - SCoords[p][1], 2));
                            aMin = Double.parseDouble(NW[0][0].toString());
                            aP = 0;
                            for (l = 1; l < points; l++) {
                                if (Double.parseDouble(NW[0][l].toString()) < aMin) {
                                    aMin = Double.parseDouble(NW[0][l].toString());
                                    aP = l;
                                }
                            }
                            if (w > aMin) {
                                NW[0][aP] = w;
                                NW[1][aP] = p;
                            }
                        }
                    }
                    if (GCoords[i][j] == -999.0) {
                        for (p = 0; p < points; p++) {
                            SV += Double.parseDouble(NW[0][p].toString()) * SCoords[Integer.parseInt(NW[1][p].toString())][2];
                            SW += Double.parseDouble(NW[0][p].toString());
                        }
                        GCoords[i][j] = SV / SW;
                    }
                }
            }
        }

        //---- Smooth with 5 points
        double s = 0.5;
        for (i = 1; i < rowNum - 1; i++) {
            for (j = 1; j < colNum - 1; j++) {
                GCoords[i][j] = GCoords[i][j] + s / 4 * (GCoords[i + 1][j] + GCoords[i - 1][j]
                        + GCoords[i][j + 1] + GCoords[i][j - 1] - 4 * GCoords[i][j]);
            }
        }

        return GCoords;
    }

    /**
     * Interpolation with IDW neighbor method
     *
     * @param SCoords                  discrete data array
     * @param X                        grid X array
     * @param Y                        grid Y array
     * @param NumberOfNearestNeighbors number of nearest neighbors
     * @param unDefData                undefine data
     * @return interpolated grid data
     */
    public static double[][] interpolation_IDW_Neighbor(double[][] SCoords, double[] X, double[] Y,
                                                        int NumberOfNearestNeighbors, double unDefData) {
        int rowNum, colNum, pNum;
        colNum = X.length;
        rowNum = Y.length;
        pNum = SCoords.length;
        double[][] GCoords = new double[rowNum][colNum];
        int i, j, p, l, aP;
        double w, SV, SW, aMin;
        int points;
        points = NumberOfNearestNeighbors;
        double[] AllWeights = new double[pNum];
        double[][] NW = new double[2][points];
        int NWIdx;

        //---- Do interpolation with IDW method
        for (i = 0; i < rowNum; i++) {
            for (j = 0; j < colNum; j++) {
                GCoords[i][j] = unDefData;
                SV = 0;
                SW = 0;
                NWIdx = 0;
                for (p = 0; p < pNum; p++) {
                    if (SCoords[p][2] == unDefData) {
                        AllWeights[p] = -1;
                        continue;
                    }
                    if (X[j] == SCoords[p][0] && Y[i] == SCoords[p][1]) {
                        GCoords[i][j] = SCoords[p][2];
                        break;
                    } else {
                        w = 1 / (Math.pow(X[j] - SCoords[p][0], 2) + Math.pow(Y[i] - SCoords[p][1], 2));
                        AllWeights[p] = w;
                        if (NWIdx < points) {
                            NW[0][NWIdx] = w;
                            NW[1][NWIdx] = p;
                        }
                        NWIdx += 1;
                    }
                }

                if (GCoords[i][j] == unDefData) {
                    for (p = 0; p < pNum; p++) {
                        w = AllWeights[p];
                        if (w == -1) {
                            continue;
                        }

                        aMin = NW[0][0];
                        aP = 0;
                        for (l = 1; l < points; l++) {
                            if ((double) NW[0][l] < aMin) {
                                aMin = (double) NW[0][l];
                                aP = l;
                            }
                        }
                        if (w > aMin) {
                            NW[0][aP] = w;
                            NW[1][aP] = p;
                        }
                    }
                    for (p = 0; p < points; p++) {
                        SV += (double) NW[0][p] * SCoords[(int) NW[1][p]][2];
                        SW += (double) NW[0][p];
                    }
                    GCoords[i][j] = SV / SW;
                }
            }
        }

        //---- Smooth with 5 points
        double s = 0.5;
        for (i = 1; i < rowNum - 1; i++) {
            for (j = 1; j < colNum - 1; j++) {
                GCoords[i][j] = GCoords[i][j] + s / 4 * (GCoords[i + 1][j] + GCoords[i - 1][j] + GCoords[i][j + 1]
                        + GCoords[i][j - 1] - 4 * GCoords[i][j]);
            }

        }

        return GCoords;
    }


}
