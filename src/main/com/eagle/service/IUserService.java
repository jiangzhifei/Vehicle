package com.eagle.service;

import com.eagle.dal.dataObject.UserDO;

/**
 * Created by jiang on 15/7/29.
 */
public interface IUserService {

    void addUser(UserDO user);

    UserDO getUserByName(String userName);
}
