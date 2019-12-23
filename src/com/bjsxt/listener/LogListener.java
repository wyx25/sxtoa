package com.bjsxt.listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LogListener implements ServletRequestListener,ServletRequestAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

        //记录日志统计操作

        //  客户端主机：    请求的时间：     发送的是哪一个请求
        HttpServletRequest req = (HttpServletRequest) servletRequestEvent.getServletRequest();








        //【A】获得客户端的IP地址

        String ip = req.getRemoteAddr();

        //【B】获得访问的时间

        String  time = new Date().toLocaleString();

        //【C】获得用户请求的地址
        String requestURI = req.getRequestURI();

        //【D】获得执行的参数/sxtoa/EmployeeController?method=add

        String queryString = req.getQueryString();


        try {
            PrintWriter out = new PrintWriter(new FileWriter("D:/log.txt",true));


            out.println("客户端IP:"+ip+"访问时间:"+time+"访问地址:"+requestURI+"执行的方法:"+queryString);

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //req.setAttribute("","");
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {


    }

    // req.removeAttribute("");
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
