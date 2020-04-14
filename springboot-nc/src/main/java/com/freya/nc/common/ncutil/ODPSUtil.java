/**
 * freya.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.common.ncutil;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author chengpiny
 */
public class ODPSUtil {
    private static String driverName = "com.aliyun.odps.jdbc.OdpsDriver";
    private static Properties config = new Properties();

    static {
        try {
            Class.forName(driverName);
            config.load(ODPSUtil.class.getClassLoader()
                    .getResourceAsStream("odps.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:odps:http://service.cn-guangdong-qx-d01.odps.ali.gd.cma/api", config);
        return connection;
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接关闭失败", e);
        }
    }

    public static void main(String[] args) throws Exception {
        Connection  connection = ODPSUtil.getConnection();
        String UTCtime = DateUtil.getUTCtime(new Date()) ;
        String sql = "select * from shuzhiyubao_dev.t_xp_gdqx_pred where pt =" + UTCtime + ";";
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet res = psmt.executeQuery();
        ResultSetMetaData mate = res.getMetaData();
        System.out.println(mate.getColumnName(4));
    }
}
