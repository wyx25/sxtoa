package com.bjsxt.service.impl;

import com.bjsxt.mapper.AuditingMapper;
import com.bjsxt.mapper.ExpenseMapper;
import com.bjsxt.pojo.Auditing;
import com.bjsxt.pojo.Expense;
import com.bjsxt.service.AuditingService;
import com.bjsxt.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class AuditingServiceImpl implements AuditingService {

    @Override
    public int saveAudit(Auditing auditing,int totalAmount,String  mgrid) {


        SqlSession session = DBUtil.getSession();

        AuditingMapper mapper = session.getMapper(AuditingMapper.class);

        ExpenseMapper mapper1 = session.getMapper(ExpenseMapper.class);


        //【1】获得审批的结果
        String result = auditing.getResult();

        if("2".equals(result)){
            //审核通过
            //获得报销的金额
            if(totalAmount<=2000){

                //二级领导直接批准  ，，执行打款的操作
                // 修改报销单记录    修改成5
                mapper1.update(auditing.getExpId(),null,"5");
            }else{
                //请下一个审批人进行审批
                //修改报销单记录   修改成2    修改下一个审批人

                if(mgrid==null||"".equals(mgrid)){
                    //直接打款即可

                    mapper1.update(auditing.getExpId(),null,"5");
                }else{
                    mapper1.update(auditing.getExpId(),mgrid,"0");
                }


            }
        }else{
            //审核打会或者拒绝
            //修改报下单记录   修改3/4
            mapper1.update(auditing.getExpId(),null,auditing.getResult());
        }
        int insert = mapper.insert(auditing);
        DBUtil.closed();

        return insert;
    }
}
