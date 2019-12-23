package com.bjsxt.controller;

import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Expense;
import com.bjsxt.pojo.ExpenseItem;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.ExpenseServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/ExpenseController")
public class ExpenseController  extends  BaseServlet{


    EmployeeService   employeeService =new EmployeeServiceImpl();

    ExpenseService  expenseService =new ExpenseServiceImpl();



    //查询领导待审报销记录
    protected void findMoreExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //【1】接受页面的数据
        Employee   employee = (Employee) req.getSession().getAttribute("employee");

        String empId = employee.getEmpId();


        //【2】数据的处理
        List<Expense> list = expenseService.findMore(empId);


        //【3】做出响应

        String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);

        resp.getWriter().println(json);


    }


        //添加报销单信息
    protected void saveExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        Employee   employee = (Employee) req.getSession().getAttribute("employee");

        java.sql.Date  date =new java.sql.Date(new Date().getTime());

        String expDesc = req.getParameter("expDesc");

        String nextAuditor = req.getParameter("nextAuditor");




        /******报销单明细*******/

        double  count=0;

        String[] types = req.getParameterValues("type");

        String[] amounts = req.getParameterValues("amount");

        String[] itemDescs = req.getParameterValues("itemDesc");

        List<ExpenseItem>  list =new ArrayList<>();
        for (int i=0 ;i<types.length;i++){

           String   type= types[i];

           Double amount=  Double.parseDouble(amounts[i]);

           String  itemDesc=itemDescs[i];

           ExpenseItem  expenseItem=new ExpenseItem( type,  amount,  itemDesc);

           list.add(expenseItem);

           count+=amount;

        }


        Expense  expense=new Expense(0, employee.getEmpId(), count, date,  expDesc,  nextAuditor, "0", "0");



        //[2]数据的处理
        int i = expenseService.saveExpense(expense,list);



        //[3]做出响应

        if(i>0){

            resp.sendRedirect(req.getContextPath()+"/myExpense.html");
        }else {

            resp.sendRedirect(req.getContextPath()+"/expenseAdd.html");
        }



    }


        //查询上级领导信息
    protected void findMoreMg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Employee> list = employeeService.findMoreMg();


        String json = new Gson().toJson(list);

        resp.getWriter().println(json);


    }
}
