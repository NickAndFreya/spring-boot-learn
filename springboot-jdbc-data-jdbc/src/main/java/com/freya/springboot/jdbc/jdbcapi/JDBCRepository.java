package com.freya.springboot.jdbc.jdbcapi;

import com.freya.springboot.jdbc.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCRepository {
    /**
     * 原来的JDBC
     *
     * @return
     * @throws SQLException
     */
    public List<Dept> findAll() throws SQLException {

        String sql = "select * from dept";
        Connection conn = DBUtil.getConnection();
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.execute();
//		查询获得结果集
        ResultSet rs = stat.executeQuery();
        List<Dept> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String loc = rs.getString("loc");
            Dept dept = new Dept();
            dept.id = id;
            dept.title = title;
            dept.loc = loc;
            list.add(dept);
        }
//		关闭连接
        rs.close();
        stat.close();
        DBUtil.close(conn);

        return list;
    }

    public static void main(String[] args) throws SQLException {
        JDBCRepository repository = new JDBCRepository();
        System.out.println(repository.findAll());
    }

}
