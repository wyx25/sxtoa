package com.bjsxt.service.impl;

import com.bjsxt.mapper.ExpenseItemMapper;
import com.bjsxt.mapper.ExpenseMapper;
import com.bjsxt.pojo.Expense;
import com.bjsxt.pojo.ExpenseItem;
import com.bjsxt.service.ExpenseService;
import com.bjsxt.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {
    @Override
    public int saveExpense(Expense expense, List<ExpenseItem> list) {

        int insert = 0;
        try {
            SqlSession session = DBUtil.getSession();

            //添加报销单
            ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);

            insert = mapper.insert(expense);

            ExpenseItemMapper mapper1 = session.getMapper(ExpenseItemMapper.class);

            //添加报销单明细
            for (ExpenseItem  expenseItem :list) {

                expenseItem.setExpId( expense.getExpId());

                 mapper1.insert(expenseItem);
            }

            return  1;
        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }finally {
            DBUtil.closed();
        }



    }

    @Override
    public List<Expense> findMore(String empid) {

        SqlSession session = DBUtil.getSession();

        ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);

        List<Expense> list = mapper.selectMore(empid);

        DBUtil.closed();

        return list;
    }
}
