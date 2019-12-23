package com.bjsxt.service;

import com.bjsxt.pojo.Expense;
import com.bjsxt.pojo.ExpenseItem;

import java.util.List;

public interface ExpenseService {


    //添加报销单信息
    public int   saveExpense(Expense  expense, List<ExpenseItem>  list);

    //查询指定上级的待审报销单
    public   List<Expense>  findMore(String  empid);

}
