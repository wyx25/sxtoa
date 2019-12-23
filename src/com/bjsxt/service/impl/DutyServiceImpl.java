package com.bjsxt.service.impl;

import com.bjsxt.mapper.DutyMapper;
import com.bjsxt.pojo.Duty;
import com.bjsxt.service.DutyService;
import com.bjsxt.util.DBUtil;

import java.util.List;

public class DutyServiceImpl implements DutyService {
    @Override
    public int SignIn(Duty duty) {


        DutyMapper mapper = DBUtil.getSession().getMapper(DutyMapper.class);

        Duty duty1 = mapper.selectOne(duty.getEmprid(), duty.getDtdate());

        if(duty1!=null){

            return  -1;
        }
        int insert = mapper.insert(duty);

        DBUtil.closed();

        return insert;
    }

    @Override
    public int SignOut(Duty duty) {

        DutyMapper mapper = DBUtil.getSession().getMapper(DutyMapper.class);

        int update = mapper.update(duty);

        DBUtil.closed();

        return update;
    }

    @Override
    public List<Duty> findMore(String emprid, String deptno, String dtdate) {

        DutyMapper mapper = DBUtil.getSession().getMapper(DutyMapper.class);


        List<Duty> list = mapper.selectMore(emprid, deptno, dtdate);

        DBUtil.closed();

        return list;
    }
}
