package com.ceshi.service;

import com.ceshi.pojo.User;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */

    User login(User user);
}
