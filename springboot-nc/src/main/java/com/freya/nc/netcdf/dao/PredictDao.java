/**
 * Longshine.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.netcdf.dao;

import com.freya.nc.common.ncutil.DateUtil;
import com.freya.nc.common.ncutil.ODPSUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.*;

/**
 * @author chengpiny.hds
 * @version $Id: PredictDao.java, v 0.1 2019-05-17 10:13 chengpiny.hds Exp $$
 */
@Repository
public class PredictDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取站点预报数据
     *
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> getPredictStation() throws Exception {

        String UTCtime = DateUtil.getUTCtime(new Date());
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> resultList = new ArrayList();

        try {
            connection = ODPSUtil.getConnection();
            String sql = "select site,la,lo,rain_future_1h,rain_future_2h,rain_future_3h from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + ";";
            logger.info("executeSQL = {}", sql);
            psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Map resultMap = new HashMap();
                resultMap.put("site", rs.getString("site"));
                resultMap.put("lat", rs.getDouble("la"));
                resultMap.put("lon", rs.getDouble("lo"));
                resultMap.put("rain_future_1h", rs.getDouble("rain_future_1h"));
                resultMap.put("rain_future_2h", rs.getDouble("rain_future_2h"));
                resultMap.put("rain_future_3h", rs.getDouble("rain_future_3h"));
                resultList.add(resultMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                rs.close();
            }
            psmt.close();
            ODPSUtil.close(connection);
        }
        return resultList;
    }
    public Map<String, Object> get1HourBeforePredictStationById(String siteId) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        String UTCtime = DateUtil.getUTCtime(calendar.getTime());
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Map resultMap = null;
        try {
            connection = ODPSUtil.getConnection();
            String sql = null;
            if (!StringUtils.isEmpty(siteId)) {
                sql = "select site,la,lo,rain_future_1h,rain_future_2h,rain_future_3h from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + "  AND site = " + "\'" + siteId + "\'" + ";";
            }
            logger.info("executeSQL = {}", sql);
            psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                resultMap = new HashMap();
                resultMap.put("site", rs.getString("site"));
                resultMap.put("lat", rs.getDouble("la"));
                resultMap.put("lon", rs.getDouble("lo"));
                resultMap.put("rain_future_1h", rs.getDouble("rain_future_1h"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                rs.close();
            }
            psmt.close();
            ODPSUtil.close(connection);
        }
        return resultMap;
    }
    public Map<String, Object> get2HourBeforePredictStationById(String siteId) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 2);
        String UTCtime = DateUtil.getUTCtime(calendar.getTime());
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Map resultMap = null;
        try {
            connection = ODPSUtil.getConnection();
            String sql = null;
            if (!StringUtils.isEmpty(siteId)) {
                sql = "select site,la,lo,rain_future_1h,rain_future_2h,rain_future_3h from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + "  AND site = " + "\'" + siteId + "\'" + ";";
            }
            logger.info("executeSQL = {}", sql);
            psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            while (rs.next()) {
                resultMap = new HashMap();
                resultMap.put("site", rs.getString("site"));
                resultMap.put("lat", rs.getDouble("la"));
                resultMap.put("lon", rs.getDouble("lo"));
                resultMap.put("rain_future_2h", rs.getDouble("rain_future_2h"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                rs.close();
            }
            psmt.close();
            ODPSUtil.close(connection);
        }
        return resultMap;
    }
    public Map<String, Object> get3HourBeforePredictStationById(String siteId) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 3);
        String UTCtime = DateUtil.getUTCtime(calendar.getTime());
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Map resultMap = null;
        try {
            connection = ODPSUtil.getConnection();
            String sql = null;
            if (!StringUtils.isEmpty(siteId)) {
                sql = "select site,la,lo,rain_future_1h,rain_future_2h,rain_future_3h from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + "  AND site = " + "\'" + siteId + "\'" + ";";
            }
            logger.info("executeSQL = {}", sql);
            psmt = connection.prepareStatement(sql);
            rs = psmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            while (rs.next()) {
                resultMap = new HashMap();
                resultMap.put("site", rs.getString("site"));
                resultMap.put("lat", rs.getDouble("la"));
                resultMap.put("lon", rs.getDouble("lo"));
                resultMap.put("rain_future_3h", rs.getDouble("rain_future_3h"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                rs.close();
            }
            psmt.close();
            ODPSUtil.close(connection);
        }
        return resultMap;
    }
}
