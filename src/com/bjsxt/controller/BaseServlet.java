package com.bjsxt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet  extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=utf-8");

        //[1]接受调用方法的名称
        String method = req.getParameter("method");
        //[2]获得类对象
        Class  clazz = this.getClass();

        System.out.println(clazz+"---"+method);

        //[3]调用方法
        try {
            Method method1 = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);

            method1.setAccessible(true);

            method1.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
