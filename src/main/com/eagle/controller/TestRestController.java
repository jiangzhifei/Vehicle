package com.eagle.controller;

import com.eagle.controller.dto.ResponseBase;
import com.eagle.dal.dataObject.UserDO;
import com.eagle.service.IUserService;
import com.eagle.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.net.URLDecoder;

/**
 * Created by jiang on 15/7/28.
 */
@RestController
@RequestMapping("/api")
public class TestRestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/greetings")
    @ResponseStatus(HttpStatus.OK)
    public ResponseBase greetings(@RequestParam("name") String name){
        ResponseBase response=new ResponseBase();
        UserDO user = new UserDO();
        user.setId(2l);
        user.setUserName("jiang");
        user.setUserPwd("12123");
//        userService.addUser(user);

        UserDO user1 = userService.getUserByName("jiang");
//        response.setPayLoad(name);
        return response;

    }
}
