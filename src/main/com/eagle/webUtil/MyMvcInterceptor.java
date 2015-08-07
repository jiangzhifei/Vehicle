package com.eagle.webUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiang on 15/7/30.
 */
public class MyMvcInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyMvcInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Enter MyMvcInterceptor");
        Object user = request.getSession().getAttribute("user");
        if (null == user) {
            response.sendRedirect("/index.jsp");
            response.setStatus(HttpStatus.NOT_MODIFIED.value());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("Enter MyMvcInterceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Enter MyMvcInterceptor");
    }
}
