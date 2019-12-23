package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        /*System.out.println("Filter1--init");*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter1--doFilter(((befor");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter1--doFilter>>>>after");
    }

    @Override
    public void destroy() {

       /* System.out.println("Filter1--destroy");*/

    }
}
