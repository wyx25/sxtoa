package com.bjsxt.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineListener implements HttpSessionAttributeListener,HttpSessionListener {



    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

        //获得保存到session中的名字

        String name = httpSessionBindingEvent.getName();

        if("employee".equals(name)){
            //证明用户登陆成功

            ServletContext context = httpSessionBindingEvent.getSession().getServletContext();


            //[A]获得此时此刻的在线人数
            Integer  online = (Integer) context.getAttribute("online");

            if(online==null){

                online=1;
            }else {
                online++;
            }


            context.setAttribute("online",online);


        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        //人数--
        ServletContext context = httpSessionEvent.getSession().getServletContext();

        Integer online = (Integer) context.getAttribute("online");

        if(online==null){
            online=0;
        }else {

            online--;
        }

        context.setAttribute("online",online);


    }
}
