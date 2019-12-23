package com.bjsxt.mapper;

import com.bjsxt.pojo.Duty;

import java.util.Date;
import java.util.List;

public interface DutyMapper {

    //增加考勤信息
    public   int  insert(Duty  duty);

    //查询指定签到用户
    public   Duty  selectOne(String  empid, Date  dtdate);

    //用户签退操作
    public   int    update(Duty  duty);


    //多条件查询指定考勤信息
    public List<Duty>  selectMore(String  emprid,String  deptno,String  dtdate);
}
