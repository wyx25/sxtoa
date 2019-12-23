package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        /*System.out.println("Filter2--init");*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter2--doFilter(((befor");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter2--doFilter>>>>after");
    }

    @Override
    public void destroy() {

       /* System.out.println("Filter2--destroy");*/

    }
}
