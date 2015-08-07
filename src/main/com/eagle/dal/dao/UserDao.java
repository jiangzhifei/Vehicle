package com.eagle.dal.dao;

import com.eagle.dal.dataObject.UserDO;

/**
 * Created by jiang on 15/7/29.
 */
public interface UserDao {

    int add(UserDO user);

    UserDO getByName(String userName);

}
