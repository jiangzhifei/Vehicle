package com.eagle.service.impl;

import com.eagle.dal.dao.UserDao;
import com.eagle.dal.dataObject.UserDO;
import com.eagle.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiang on 15/7/29.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    public void addUser(UserDO user) {
        userDao.add(user);
    }

    public UserDO getUserByName(String userName) {

        return userDao.getByName(userName);
    }
}
