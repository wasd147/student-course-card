package com.example.jingtao.intereptor;

import com.example.jingtao.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyIntereptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(new Date().toString()+" "+ request.getRemoteAddr() + "进入拦截器 " + request.getRequestURI());

        String token = request.getHeader("token");
        if (token == null) {
            System.out.println("请求头不存在token");
            //token不存在
            //之后可能要写的处理
            response.sendRedirect("/notlogin");
            return false;
        } else {
            int res = TokenUtils.testToken(token);
            if (res == (0)) {
                //token无效
                System.out.println("token在数据库中不存在");
                response.sendRedirect("/notlogin");
                return false;
            } else {
                if (res == (-1)) {
                    //token过期
                    System.out.println("token已经过期");
                    response.sendRedirect("/notlogin");
                    TokenUtils.deleteOutToken(token);
                    return false;
                } else {
                    //token有效
                    return true;
                }
            }

        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
