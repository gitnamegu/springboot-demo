package com.bong.springbootdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springboot整合servlet. springboot没有web.xml，顶注解完成servlet组件
* @author dabing
 * @create 2018/11/29
 * @since 1.0.0
 */
@WebServlet(name = "servletDemo", urlPatterns = "/servlet/demo")
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        System.out.println("servlet=================");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("张三zhangsan");
    }
}
