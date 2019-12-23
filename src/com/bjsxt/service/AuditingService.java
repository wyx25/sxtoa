package com.bjsxt.service;

import com.bjsxt.pojo.Auditing;

public interface AuditingService {

    //增加审核的记录
    public   int  saveAudit(Auditing auditing,int totalAmount,String mgrid);
}
