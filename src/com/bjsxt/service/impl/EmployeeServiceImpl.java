package com.bjsxt.service.impl;

import com.bjsxt.mapper.EmployeeMapper;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.util.DBUtil;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public int save(Employee employee) {

        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);

        int insert = mapper.insert(employee);

        DBUtil.closed();

        return insert;
    }

    @Override
    public List<Employee> findAll(String empid,String  deptno,String  onduty,String  hireDate) {

        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);

        List<Employee> list = mapper.selectAll(empid,deptno,onduty,hireDate);

        DBUtil.closed();


        return list;
    }

    @Override
    public int delete(String empid) {
        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);


        int delete = mapper.delete(empid);

        DBUtil.closed();


        return delete;
    }

    @Override
    public Employee findOne(String empid) {
        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectOne(empid);

        DBUtil.closed();

        return employee;
    }

    @Override
    public int change(Employee emp) {

        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);

        int update = mapper.update(emp);

        DBUtil.closed();

        return update;
    }

    @Override
    public List<Employee> findMoreMg() {

        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);

        List<Employee> list = mapper.selectMore();

        DBUtil.closed();


        return list;
    }

    @Override
    public Employee login(String empid, String pwd) {

        EmployeeMapper mapper = DBUtil.getSession().getMapper(EmployeeMapper.class);


        Employee employee = mapper.selectOne2(empid, pwd);

        DBUtil.closed();

        return employee;
    }
}
