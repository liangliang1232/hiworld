package com.ceshi.dao;

import com.ceshi.pojo.User;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    User find(String username, String password);


}