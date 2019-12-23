package com.bjsxt.service.impl;

import com.bjsxt.mapper.InComeMapper;
import com.bjsxt.pojo.InCome;
import com.bjsxt.pojo.VN;
import com.bjsxt.service.InComeService;
import com.bjsxt.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class InComeServiceImpl implements InComeService {
    @Override
    public List findMore() {

        InComeMapper mapper = DBUtil.getSession().getMapper(InComeMapper.class);


        List<InCome> list = mapper.selectMore();

        //保存的收支类型--横
        List<String>   li=new ArrayList<>();


        //保存的收支总金额--纵
        List<Integer>   li2=new ArrayList<>();




        for (InCome  inCome:list){

            String ictype = inCome.getIctype();
            li.add(ictype);

            Integer amount = inCome.getAmount();
            li2.add(amount);
        }

        List   li3=new ArrayList();
        li3.add(li);
        li3.add(li2);


        return li3;
    }

    @Override
    public List<VN> findMore2() {

        InComeMapper mapper = DBUtil.getSession().getMapper(InComeMapper.class);

        List<VN> list = mapper.selectMore2();

        DBUtil.closed();


        return list;
    }
}
