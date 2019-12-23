package com.bjsxt.controller;

import com.bjsxt.pojo.Dept;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeptController")
public class DeptController extends BaseServlet {

    DeptService  deptService=new DeptServiceImpl();

/*

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



           //获得接受参数的方法名
        String method = req.getParameter("method");

        if("deptSave".equals(method)){

            deptSave(req,resp);

        }else if("findAllDept".equals(method)){

            findAllDept(req,resp);
        }else if("removeDept".equals(method)){

            removeDept(req,resp);
        }else  if("findOneDept".equals(method)){

            findOneDept(req,resp);

        }else if("changeDept".equals(method)){

            changeDept(req,resp);
        }

    }
*/


    //修改部门信息
    protected void changeDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        int deptno = Integer.parseInt(req.getParameter("deptno"));

        String deptname = req.getParameter("deptname");

        String location = req.getParameter("location");

        Dept  dept=new Dept(deptno,deptname,location);

        //[2]数据的处理
        int change = deptService.change(dept);

        //[3]做出响应
        if(change>0){

            resp.sendRedirect("/sxtoa/DeptController?method=findAllDept");
        }else {


            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);
        }


    }


        //查询部门信息
    protected void findOneDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据
        Integer deptno=Integer.parseInt(req.getParameter("deptno"));

        //[2]数据的处理

        Dept dept = deptService.findOne(deptno);


        //[3]给用户做出响应

        req.setAttribute("dept",dept);
        req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);


    }

        //查询部门信息
    protected void removeDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        Integer   deptno=Integer.parseInt(req.getParameter("deptno"));


        //[2]数据处理
        int remove = deptService.remove(deptno);

        //[3]做出响应

        resp.sendRedirect("/sxtoa/DeptController?method=findAllDept");


    }


        //查询部门信息
    protected void findAllDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        //[2]数据处理

        List<Dept> list = deptService.findAll();

        //[3]做出响应

        req.setAttribute("list",list);
        req.getRequestDispatcher("/deptList.jsp").forward(req,resp);



    }




        //添加部门操作
    protected void deptSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

         Integer  deptno =Integer.parseInt(req.getParameter("deptno"));

         String   deptname =req.getParameter("deptname");

         String  location =req.getParameter("location");

        Dept  dept =new Dept(deptno,deptname,location);


        //[2]数据处理


        int save = deptService.save(dept);


        //[3]做出响应

        if(save>0){

           resp.sendRedirect("/sxtoa/deptList.html");

        }else{
            resp.sendRedirect("/sxtoa/deptAdd.html");

        }




    }
    }
