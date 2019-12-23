package com.bjsxt.service.impl;

import com.bjsxt.mapper.DeptMapper;
import com.bjsxt.pojo.Dept;
import com.bjsxt.service.DeptService;
import com.bjsxt.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {


    @Override
    public int save(Dept dept) {


             SqlSession session = DBUtil.getSession();

             DeptMapper  mapper= session.getMapper(DeptMapper.class);

             int insert = mapper.insert(dept);

             session.commit();

             DBUtil.closed();

        return insert;
    }

    @Override
    public List<Dept> findAll() {


        SqlSession session = DBUtil.getSession();

        DeptMapper mapper = session.getMapper(DeptMapper.class);

        List<Dept> list = mapper.selectAll();

        DBUtil.closed();

        return list;
    }

    @Override
    public int remove(int deptno) {

        DeptMapper mapper = DBUtil.getSession().getMapper(DeptMapper.class);

        int delete = mapper.delete(deptno);

        DBUtil.closed();

        return delete;
    }

    @Override
    public Dept findOne(int deptno) {
        DeptMapper mapper = DBUtil.getSession().getMapper(DeptMapper.class);

        Dept dept = mapper.selectOne(deptno);

        DBUtil.closed();


        return dept;
    }

    @Override
    public int change(Dept dept) {

        DeptMapper mapper = DBUtil.getSession().getMapper(DeptMapper.class);


        int update = mapper.update(dept);

         DBUtil.closed();

        return update;
    }


}
