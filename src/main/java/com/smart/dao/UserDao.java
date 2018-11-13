package com.smart.dao;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/9 11:39
 */
//@Repository
@Component
public interface UserDao {
    int getMatchCount(String userName, String password);
}
