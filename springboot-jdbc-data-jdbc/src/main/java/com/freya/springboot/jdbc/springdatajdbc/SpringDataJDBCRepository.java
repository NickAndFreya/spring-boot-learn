package com.freya.springboot.jdbc.springdatajdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.freya.springboot.jdbc.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDataJDBCRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //	结果集记录的一行,映射特定的对象
    RowMapper<Dept> mapper = new RowMapper<Dept>() {
        @Override
        public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dept dept = new Dept();
            dept.setId(rs.getInt("id"));
            dept.setTitle(rs.getString("title"));
            dept.setLoc(rs.getString("loc"));
            return dept;
        }
    };


    /**
     * jdbcTemplate
     *
     * @return Dept对象构成的列表/结果集记录行
     */

    public List<Dept> findALL() {

        return jdbcTemplate.query("select * from dept", mapper);
    }

    /**
     * jdbcTemplate
     *
     * @param loc
     * @return
     */
    public List<Dept> findByLoc(String loc) {
//		sql语句
        String sql = "select * from dept where loc like ?";
//		参数
        Object[] args = {loc};
//		执行查询
        return jdbcTemplate.query(sql, args, mapper);
    }

    public void remove(int id) {

        String sql = "delete "
                + "from dept "
                + "where id=? "
                + "and "
                + "loc=? ";
        jdbcTemplate.execute(sql);
    }

}