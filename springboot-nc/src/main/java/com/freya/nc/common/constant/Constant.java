package com.freya.nc.common.constant;

/**
 * 常量
 *
 * @author chengpinyuan
 */
public class Constant {
    public enum Meteorology {
        LAT_BEGIN(18.21d),
        LAT_END(27d),
        LON_BEGIN(108.5d),
        LON_END(118.99d),
        LAT_DIMS(880d),
        LON_DIMS(1050d),
        GRID_INTERVAL(0.01d),
        NEIGHBOR_POINT(20d);

        private double value;

        Meteorology(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    public enum NCMLTemp {
        JAN("rainfall01.ncml"),
        FEB_NOLEAP("rainfall02-1.ncml"),
        FEB_LEAP("rainfall02-2.ncml"),
        MAR("rainfall03.ncml"),
        APR("rainfall04.ncml"),
        MAY("rainfall05.ncml"),
        JUNE("rainfall06.ncml"),
        JULY("rainfall07.ncml"),
        AUG("rainfall08.ncml"),
        SEP("rainfall09.ncml"),
        OCT("rainfall10.ncml"),
        NOV("rainfall11.ncml"),
        DEC("rainfall12.ncml");
        private String value;

        NCMLTemp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
