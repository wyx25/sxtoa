package com.bjsxt.service;

import com.bjsxt.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    //添加员工操作
    public   int   save(Employee  employee);

    //查询所有员工操作
    public List<Employee> findAll(String empid,String  deptno,String  onduty,String  hireDate);

    //删除指定员工操作
    public   int   delete(String  empid);

    //查询单个员工操作
    public   Employee   findOne(String  empid);

    //修改员工操作
    public   int  change(Employee  emp);

    //查询所有上级领导
    public   List<Employee>  findMoreMg();

    //用户的登陆
    public   Employee   login(String  empid,String  pwd);
}
