package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Duty implements Serializable {

    private   int  dtid;

    private   String  emprid;

    private Date   dtdate;

    private   String  signintime;

    private   String  signouttime;


    //增加属性
    private   String  realname;

    //增加部门名称
    private   String  deptname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getDtid() {
        return dtid;
    }

    public void setDtid(int dtid) {
        this.dtid = dtid;
    }

    public String getEmprid() {
        return emprid;
    }

    public void setEmprid(String emprid) {
        this.emprid = emprid;
    }

    public Date getDtdate() {
        return dtdate;
    }

    public void setDtdate(Date dtdate) {
        this.dtdate = dtdate;
    }

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime;
    }

    public String getSignouttime() {
        return signouttime;
    }

    public void setSignouttime(String signouttime) {
        this.signouttime = signouttime;
    }

    public Duty(int dtid, String emprid, Date dydate, String signintime, String signouttime) {
        this.dtid = dtid;
        this.emprid = emprid;
        this.dtdate = dydate;
        this.signintime = signintime;
        this.signouttime = signouttime;
    }
    public Duty(){}

    @Override
    public String toString() {
        return "Duty{" +
                "dtid=" + dtid +
                ", emprid='" + emprid + '\'' +
                ", dydate=" + dtdate +
                ", signintime='" + signintime + '\'' +
                ", signouttime='" + signouttime + '\'' +
                '}';
    }
}
