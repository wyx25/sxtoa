package com.bjsxt.service;

import com.bjsxt.pojo.Dept;

import java.util.List;

public interface DeptService {

    //添加部门操作
    public   int  save(Dept  dept);

    //查询部门的操作
    public List<Dept> findAll();

    //删除部门信息
    public   int   remove(int  deptno);

    //查询单个部门操作
    public   Dept   findOne(int  deptno);

    //修改部门信息
    public   int    change(Dept  dept);
}
