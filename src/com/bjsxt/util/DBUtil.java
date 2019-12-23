package com.bjsxt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {

   private   static SqlSessionFactory factory=null;

   private static ThreadLocal<SqlSession>  th=new ThreadLocal<>();

   static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获得session对象
    public static SqlSession   getSession(){

        SqlSession sqlSession = th.get();

        if(sqlSession==null){

            sqlSession=factory.openSession(true);

            th.set(sqlSession);
        }
        return th.get();
    }

    //关闭session的操作
    public   static     void   closed(){

        SqlSession sqlSession = th.get();

        if(sqlSession!=null){

            sqlSession.close();

        }

        th.set(null);

    }


}
