package com.eagle.webUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jiang on 15/7/30.
 */
public class MyMvcInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyMvcInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("Enter MyMvcInterceptor.preHandle,request=[{}]", request.getRequestURL());

        HttpSession session = request.getSession();
        if (null == session) {
            response.sendRedirect("/index.jsp");
            response.setStatus(HttpStatus.NOT_MODIFIED.value());

            logger.debug("Exit MyMvcInterceptor.preHandle");
            return false;
        }
        Object user = session.getAttribute("user");
        if (null == user) {
            response.sendRedirect("/index.jsp");
            response.setStatus(HttpStatus.NOT_MODIFIED.value());

            logger.debug("Exit MyMvcInterceptor.preHandle");
            return false;
        }

        logger.debug("Exit MyMvcInterceptor.preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        logger.info("Enter MyMvcInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        logger.info("Enter MyMvcInterceptor.afterCompletion");
    }
}
