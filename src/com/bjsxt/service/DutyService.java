package com.bjsxt.service;

import com.bjsxt.pojo.Duty;

import java.util.List;

public interface DutyService {

    //添加考勤信息
    public   int   SignIn(Duty duty);

    //用户签退操作
    public   int   SignOut(Duty  duty);

    //多条件查询指定考勤信息
    public List<Duty>   findMore(String  emprid,String  deptno,String  dtdate);


}
