package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginConFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest  request= (HttpServletRequest) req;
        HttpServletResponse  response = (HttpServletResponse) resp;
        
        
        //[1]获得session 中的内容

        Object obj = request.getSession().getAttribute("employee");


        String requestURI = request.getRequestURI();

        //StringBuffer requestURL = request.getRequestURL();

        if("/sxtoa/login.jsp".equals(requestURI)||"/sxtoa/EmployeeController".equals(requestURI)){

            chain.doFilter(req,resp);
        }else {

            if(obj==null){

                response.sendRedirect("/sxtoa/login.jsp");
                return;
            }else {

                //执行下一个过滤器或者目标资源
                chain.doFilter(req,resp);

            }

        }





    }

    @Override
    public void destroy() {

    }
}
