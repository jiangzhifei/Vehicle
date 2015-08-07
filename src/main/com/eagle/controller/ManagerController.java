package com.eagle.controller;

import com.eagle.dal.dataObject.UserDO;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiang on 15/7/30.
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {

    @RequestMapping("/mainBoard")
    public ModelAndView toMainBoard(HttpServletRequest request){
        UserDO user =(UserDO)request.getSession().getAttribute("user");

        return new ModelAndView("mainBoard").addObject("userName",user.getUserName());
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");

        response.setStatus(HttpStatus.FOUND.value());
        response.setHeader("location","/index.jsp");

    }

    @RequestMapping("/gpsList")
    public ModelAndView gpsList(HttpServletRequest request){
        return new ModelAndView("gpsBoard");
    }

    @RequestMapping("/vehicleInput.htm")
    public ModelAndView vehicleInput(HttpServletRequest request,HttpServletResponse response){

        String eTag= Hashing.goodFastHash(32).hashUnencodedChars("vehicleInput").toString();
        if (eTag.toString().equals(request.getHeader("If-None-Match"))) {
            response.setHeader("Cache-Control", "max-age=300");
            response.setStatus(HttpStatus.NOT_MODIFIED.value());
        }else{
            response.setHeader("ETag", eTag.toString());
            response.setHeader("Cache-Control", "max-age=300");
        }
        return new ModelAndView("vehicleInput");
    }
}
