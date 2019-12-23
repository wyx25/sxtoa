package com.bjsxt.mapper;

import com.bjsxt.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    //添加员工操作
    public   int   insert(Employee  employee);

    //查询所有员工信息
    public List<Employee>  selectAll(String empid,String  deptno,String  onduty,String  hireDate);

    //删除指定员工
    public   int   delete(String  empid);

    //查询单个员工操作
    public   Employee   selectOne(String  empid);

    //修改员工操作
    public   int   update(Employee  employee);

    //查询所有上级领导
    public   List<Employee>  selectMore();

    //查询指定用户操作
    public   Employee    selectOne2(String  empid,String pwd);

}
