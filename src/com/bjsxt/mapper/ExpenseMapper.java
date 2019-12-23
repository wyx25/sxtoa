package com.bjsxt.mapper;

import com.bjsxt.pojo.Expense;

import java.util.List;

public interface ExpenseMapper {

    //添加报销单信息
    public   int   insert(Expense expense);


    //查询指定领导的待审报销记录
    public List<Expense>  selectMore(String  empid);

    //修改保销单操作
    public  int   update(int  expid,String  nexta ,String  status);

}
