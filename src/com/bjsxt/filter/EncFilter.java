package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncFilter implements Filter {


    String enc="";
    //初始化方法---执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
        
        //读取初始化参数
         //enc = filterConfig.getInitParameter("uu");
        //读取全局参数
        enc = filterConfig.getServletContext().getInitParameter("tt");
    }

    // 每一次请求都执行
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //【A】到达目标资源之前的处理操作

        request.setCharacterEncoding(enc);


        //【B】执行下一个过滤器或者目标资源

        chain.doFilter(request,response);

        //【C】离开服务器之前的操作




    }

    //销毁方法 --执行一次
    @Override
    public void destroy() {

    }
}
