package com.ceshi.service.impl;


import com.ceshi.dao.UserDao;
import com.ceshi.dao.impl.UserDaoImpl;
import com.ceshi.pojo.User;
import com.ceshi.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();



    @Override
    public User login(User user) {
        //调用Dao完成查询
        return dao.find(user.getUsername(),user.getPassword());
    }
}
