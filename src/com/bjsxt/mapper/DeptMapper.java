package com.bjsxt.mapper;

import com.bjsxt.pojo.Dept;

import java.util.List;

public interface DeptMapper  {

    //添加部门操作
    public   int    insert(Dept  dept);

    //查询部门信息
    public List<Dept>   selectAll();

    //删除部门信息操作
    public   int   delete(int  deptno);

    //查询单个信息
    public    Dept   selectOne(int  deptno);

    //修改部门信息
    public   int   update(Dept  dept);


}
