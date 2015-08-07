package com.eagle.controller;

import com.eagle.dal.dataObject.UserDO;
import com.eagle.service.IUserService;
import com.eagle.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiang on 15/7/29.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("userName");
        logger.info("Enter login,name={}", userName);
        String res = null;
        String pwd = request.getParameter("password");
        try {
            UserDO user = userService.getUserByName(userName);
            if (null == user) {
                res = new String(new String("用户不存在").getBytes("utf-8"), "utf-8");
            } else {
                String encryptedPwd = EncryptUtil.encryptSha256(pwd);
                if (user.getUserPwd().equals(encryptedPwd)) {
                    if (0 == user.getIsActive()) {
                        res = "用户为激活";
                    } else if (1 == user.getIsLocked()) {
                        res = "用户被锁定";
                    } else {
                        request.getSession(true).setAttribute("user", user);
                        res = "0";
                    }
                } else {
                    res = new String(new String("密码错误").getBytes("utf-8"), "utf-8");
                }
            }
        } catch (Exception e) {
            logger.error("login error,userName={}", userName, e);
            res = "系统错误";
        }

        logger.info("Exit login,res={}", res);
        return res;
    }
}
