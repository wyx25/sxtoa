package com.bjsxt.controller;

import com.bjsxt.pojo.Dept;
import com.bjsxt.pojo.Duty;
import com.bjsxt.pojo.Employee;
import com.bjsxt.service.DeptService;
import com.bjsxt.service.DutyService;
import com.bjsxt.service.impl.DeptServiceImpl;
import com.bjsxt.service.impl.DutyServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/DutyController")
public class DutyController extends  BaseServlet {

    DutyService  dutyService =new DutyServiceImpl();

    DeptService  deptService =new DeptServiceImpl();


    protected void  POIfindMoreDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        String empid = req.getParameter("empid");

        String deptno = req.getParameter("deptno");

        String dtdate = req.getParameter("dtdate");


        //[2]数据处理

        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);

        //[3]导出数据


        createExcel(list,resp);
    }


    private static void createExcel(List<Duty> list,HttpServletResponse resp) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤表一");

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                3 // last column
        );
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤列表");

        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        headCell.setCellStyle(cellStyle);


        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("出勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("签到日期");
        headCell.setCellStyle(cellStyle);

        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty duty = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(duty.getEmprid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(duty.getDeptname());
            cell.setCellStyle(cellStyle);

            String format = new SimpleDateFormat("yyyy-MM-dd").format(duty.getDtdate());

            cell = hssfRow.createCell(2);
            cell.setCellValue(format);
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(duty.getSignintime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {

            //OutputStream outputStream = new FileOutputStream("D:/students.xls");


            //设置响应的类型
            resp.setContentType("application/vnd.ms-excel");

            //设置响应头
            resp.setHeader("Content-Disposition","attachment;filename=duty.xls");

            //客户端地址
            OutputStream outputStream = resp.getOutputStream();

            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    //多条件查询指定的考勤信息
    protected void  findMoreDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据

        String empid = req.getParameter("empid");

        String deptno = req.getParameter("deptno");

        String dtdate = req.getParameter("dtdate");


        //[2]数据处理

        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);



        //String json = new Gson().toJson(list);

        //处理含有日期时间的操作
        String  json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);


        //[3]做出响应

        resp.getWriter().println(json);




    }

        //查询所部门操作
    protected void  findAllDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Dept> list = deptService.findAll();


        String json = new Gson().toJson(list);

        resp.getWriter().println(json);


    }


        //用户签退
    protected void  signOutDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //[1]接受页面数据
        //获得登陆人员ID
        Employee emp= (Employee) req.getSession().getAttribute("employee");

        String empId = emp.getEmpId();
        //当前的日期
        java.sql.Date  date=new java.sql.Date(new Date().getTime());

        //当前的时间
        String format = new SimpleDateFormat("HH:mm:ss").format(new Date());

        Duty   duty=new Duty();
        duty.setEmprid(empId);
        duty.setDtdate(date);
        duty.setSignouttime(format);

        //[2]数据的处理
        int i = dutyService.SignOut(duty);

        //[3]做出响应

        resp.getWriter().println(i);



    }



        //用户签到
    protected void  signInDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            //[1]接受页面数据

        //获得登陆人员ID
        Employee emp= (Employee) req.getSession().getAttribute("employee");

        String empId = emp.getEmpId();

        //获得当前的时间
        Date  date=new Date();

        // 2019-08-08
        java.sql.Date   dydate=new java.sql.Date(date.getTime());

        //时分秒
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        String signintime = simpleDateFormat.format(date);


         Duty   duty=new Duty(0, empId,  dydate,  signintime, "00:00:00");

           //[2]数据处理

        int i = dutyService.SignIn(duty);

        //[3]做出响应
       resp.getWriter().println(i);

    }
}
