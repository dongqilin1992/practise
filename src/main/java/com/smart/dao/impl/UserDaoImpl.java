package com.smart.dao.impl;

import com.smart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/9 11:41
 */
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int getMatchCount(String userName, String password) {
        String sql = "select count(*) from t_user where user_name = ? and password = ?";
        List list = jdbcTemplate.queryForList(sql, new Object[]{userName, password});
        System.out.println(list.size());

        return list.size();
    }
}
