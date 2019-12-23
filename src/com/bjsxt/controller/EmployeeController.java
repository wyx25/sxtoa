package com.bjsxt.controller;

import com.bjsxt.pojo.Dept;
import com.bjsxt.pojo.Employee;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/EmployeeController")
public class EmployeeController extends BaseServlet {


    EmployeeService  employeeService=new EmployeeServiceImpl();

    DeptService   deptService =new DeptServiceImpl();

    PositionService  positionService=new PositionServiceImpl();



    //用户退出

    protected void loginOutEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]注销当前session

        req.getSession().invalidate();


        //[2]跳转到登录页面

        //  /sxtoa
        //System.out.println(req.getContextPath());
        resp.sendRedirect( req.getContextPath()+"/login.jsp");

    }
        //用户登陆
    protected void loginEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //【1】接受页面数据
        String empid = req.getParameter("empid");

        String pwd = req.getParameter("pwd");

        /*************验证码的判断***********/

        //用户自己输入的
        String yzm1 = req.getParameter("yzm1");

        //获得系统产生的
        String randStr = (String) req.getSession().getAttribute("randStr");

        if(yzm1==null||"".equals(yzm1)||!yzm1.equals(randStr)){


            req.setAttribute("msg","yzm Error");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }


        //【2】数据的处理

        Employee employee = employeeService.login(empid, pwd);

        //【3】做出响应

        if(employee!=null){

            /******欢迎XX登陆*********/

            //【A】获得session
            HttpSession session = req.getSession();

            session.setAttribute("employee",employee);



            resp.sendRedirect("/sxtoa/main.html");
        }else {

             resp.sendRedirect("/sxtoa/login.jsp");
        }



    }



        //查询部门、岗位、上级领导信息
    protected void findDeptPosMg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //查询所有的部门
        List<Dept> deptList = deptService.findAll();

        //查询所有的岗位
        List<Position> positionList = positionService.findAll();

        //查询所有的上级领导

        List<Employee> employeeList = employeeService.findMoreMg();


        req.setAttribute("deptList",deptList);
        req.setAttribute("positionList",positionList);
        req.setAttribute("employeeList",employeeList);
        req.getRequestDispatcher("/empAdd.jsp").forward(req,resp);


    }



        //修改指定员工操作
    protected void changeEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //【1】接受页面数据
        String empId = req.getParameter("empId");

        String password = req.getParameter("password");

        Integer  deptno=Integer.parseInt(req.getParameter("deptno"));

        Integer posid=Integer.parseInt(req.getParameter("posid"));

        String  mgrid=req.getParameter("mgrid");

        String realName = req.getParameter("realName");

        String sex = req.getParameter("sex");

        java.sql.Date birthDate= java.sql.Date.valueOf(req.getParameter("birthDate"));

        java.sql.Date hireDate= java.sql.Date.valueOf(req.getParameter("hireDate"));

        java.sql.Date leaveDate= java.sql.Date.valueOf(req.getParameter("leaveDate"));

        Integer onDuty=Integer.parseInt(req.getParameter("onDuty"));

        Integer empType=Integer.parseInt(req.getParameter("empType"));

        String phone = req.getParameter("phone");

        String qq = req.getParameter("qq");

        String emerContactPerson = req.getParameter("emerContactPerson");

        String idCard = req.getParameter("idCard");

        Employee  emp=new Employee( empId,  password,  deptno,  posid,
                mgrid,  realName, sex,  birthDate,
                hireDate,  leaveDate,  onDuty,  empType,
                phone,  qq,  emerContactPerson,  idCard);
        //【2】数据处理
        int change = employeeService.change(emp);

        //【3】做出响应

        if(change>0){
            resp.sendRedirect("/sxtoa/EmployeeController?method=findAllEmployee");
        }else {

            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/empUpdate.jsp").forward(req,resp);
        }


    }

        //查询指定员工操作
    protected void findOneEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  empid=req.getParameter("empid");

        Employee employee = employeeService.findOne(empid);

        //【A】所有部门信息
        List<Dept> deptList = deptService.findAll();

        //【B】岗位信息
        List<Position> positionList = positionService.findAll();

        //【C】上级领导

        List<Employee> employeeList = employeeService.findMoreMg();


        req.setAttribute("deptList",deptList);
        req.setAttribute("positionList",positionList);
        req.setAttribute("employeeList",employeeList);
        req.setAttribute("emp",employee);
        req.getRequestDispatcher("/empUpdate.jsp").forward(req,resp);


    }

        //删除指定员工操作
    protected void removeEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //【1】接受页面数据

         String  empid=req.getParameter("empid");

       //【2】数据的处理

        int delete = employeeService.delete(empid);


        //【3】做出响应

        resp.sendRedirect("/sxtoa/EmployeeController?method=findAllEmployee");


    }

        //查询所有员工操作
    protected void  findAllEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         //[1]接受数据

        String empid = req.getParameter("empid");
          //   6  '6'
        String deptno =  req.getParameter("deptno");

        String onduty = req.getParameter("onduty");

        String  hireDate=req.getParameter("hireDate");




        //[2]数据处理
        List<Employee> list = employeeService.findAll(empid,deptno,onduty,hireDate);

        //[3]给用户做出响应

        req.setAttribute("list",list);
        req.setAttribute("empid",empid);
        req.getRequestDispatcher("/empList.jsp").forward(req,resp);


    }

        //添加员工信息操作
        protected void  saveEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        String empId = req.getParameter("empId");

        String password = req.getParameter("password");

        Integer  deptno=Integer.parseInt(req.getParameter("deptno"));

        Integer posid=Integer.parseInt(req.getParameter("posid"));

        String  mgrid=req.getParameter("mgrid");

        String realName = req.getParameter("realName");

        String sex = req.getParameter("sex");

        java.sql.Date birthDate= java.sql.Date.valueOf(req.getParameter("birthDate"));

        java.sql.Date hireDate= java.sql.Date.valueOf(req.getParameter("hireDate"));

        java.sql.Date leaveDate= java.sql.Date.valueOf(req.getParameter("leaveDate"));

        Integer onDuty=Integer.parseInt(req.getParameter("onDuty"));

        Integer empType=Integer.parseInt(req.getParameter("empType"));

        String phone = req.getParameter("phone");

        String qq = req.getParameter("qq");

        String emerContactPerson = req.getParameter("emerContactPerson");

        String idCard = req.getParameter("idCard");

        Employee  emp=new Employee( empId,  password,  deptno,  posid,
         mgrid,  realName, sex,  birthDate,
                 hireDate,  leaveDate,  onDuty,  empType,
         phone,  qq,  emerContactPerson,  idCard);
        //[2]数据处理

        int save = employeeService.save(emp);

        //[3]做出响应

        if(save>0){
            resp.sendRedirect("/sxtoa/empList.html");
        }else {
            resp.sendRedirect("/sxtoa/empAdd.html");
        }

    }
}
