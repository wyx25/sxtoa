package com.bjsxt.mapper;

import com.bjsxt.pojo.InCome;
import com.bjsxt.pojo.VN;

import java.util.List;

public interface InComeMapper {

    //查询收入图操作
    public List<InCome> selectMore();

    public    List<VN> selectMore2();
}
