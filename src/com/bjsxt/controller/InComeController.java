package com.bjsxt.controller;

import com.bjsxt.pojo.VN;
import com.bjsxt.service.InComeService;
import com.bjsxt.service.impl.InComeServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/InComeController")
public class InComeController extends  BaseServlet {

    InComeService comeService=new InComeServiceImpl();

    protected void inComeEa2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<VN> list = comeService.findMore2();

        String json = new Gson().toJson(list);

        resp.getWriter().println(json);


    }



        protected void inComeEa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        List list = comeService.findMore();

        String json = new Gson().toJson(list);

        resp.getWriter().println(json);


    }
}
