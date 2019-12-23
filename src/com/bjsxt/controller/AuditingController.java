package com.bjsxt.controller;

import com.bjsxt.pojo.Auditing;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.AuditingService;
import com.bjsxt.service.impl.AuditingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/AuditingController")
public class AuditingController extends  BaseServlet {


    AuditingService  auditingService =new AuditingServiceImpl();

    //增加审核记录
    protected void saveAuditing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //【1】接受页面数据

        int expId = Integer.parseInt(req.getParameter("expId"));

        String result = req.getParameter("result");

        String auditDesc = req.getParameter("auditDesc");

        Employee employee = (Employee) req.getSession().getAttribute("employee");

        String empId = employee.getEmpId();

        java.sql.Date   date =new java.sql.Date(new Date().getTime());

        Auditing  auditing =new Auditing( expId,  empId,  result,  auditDesc, date);

        //获得报销的金额
        int    totalAmount=Integer.parseInt(req.getParameter("totalAmount"));

        //获得当前用户的上级
        String mgrid = employee.getMgrid();

        //【2】数据的处理

        int i = auditingService.saveAudit(auditing,totalAmount, mgrid);

        //【3】做出响应

        resp.getWriter().println(i);




    }
}
