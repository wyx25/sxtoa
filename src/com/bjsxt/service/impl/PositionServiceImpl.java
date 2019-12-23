package com.bjsxt.service.impl;

import com.bjsxt.mapper.PositionMapper;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.PositionService;
import com.bjsxt.util.DBUtil;

import java.util.List;

public class PositionServiceImpl implements PositionService {

    @Override
    public List<Position> findAll() {

        PositionMapper mapper = DBUtil.getSession().getMapper(PositionMapper.class);

        List<Position> list = mapper.selectAll();

        DBUtil.closed();

        return list;
    }
}
