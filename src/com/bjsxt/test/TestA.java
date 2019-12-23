package com.bjsxt.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestA {

    public static void main(String[] args) {


        Date  date=new Date();


        java.sql.Date   date1=new java.sql.Date(date.getTime());

        System.out.println(date1);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        String format = simpleDateFormat.format(date);

        System.out.println(format);



    }
}
