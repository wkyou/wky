package com.wang.web.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wang.common.utils.ExcelUtil;
import com.wang.dao.entity.TUser;
import com.wang.dao.mapper.TUserMapper;
import com.wang.web.pojo.UserExcelDto;
import com.wang.web.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author WangKanYou
 * @Date 2022/11/26 23:48
 * @描述:
 */
@Service
@Slf4j
public class ExcelServiceImpl implements ExcelService {
    @Resource
    private TUserMapper tUserMapper;

    @Override
    @Transactional //可以在此添加事务
    public List<TUser> testExcel(MultipartFile multipartFile) {
        AnalysisEventListener<UserExcelDto> listener = ExcelUtil.getListener(this.batchInsert(), 2500);
        try {
            ExcelReader excelReader = EasyExcel.read(multipartFile.getInputStream(), UserExcelDto.class, listener).doReadAll();//读取全部的sheet
            excelReader.finish();
//            EasyExcel.read(multipartFile.getInputStream(), UserExcelDto.class, listener).sheet("sheet2").doRead();  //读取指定的sheet
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Async
    Consumer<List<UserExcelDto>> batchInsert(){
        return data->{
            int updateSuccessNum=0,updateFailNum=0,insSuccessNum=0,insFailNum=0;
            for (UserExcelDto user : data) {
                TUser hisuser = new TUser();
                hisuser.setPaymentStatus(Integer.parseInt(user.getTransactionStatus()));//缴费状态
                hisuser.setInsuranceDocumentNo("");//医保单据号
                hisuser.setInsuranceRefundSerialNo("");//医保撤销流水号
                hisuser.setInsuranceSerialNumber("");//医保流水号
                hisuser.setTotalAmount(0);//总金额
                Integer payType =2;
                hisuser.setPayType(payType);//支付方式
                hisuser.setServiceChannel(user.getServiceChannel());//服务渠道
                hisuser.setCreateTime(LocalDateTime.now());//创建订单时间
                hisuser.setBusinessType(3);//业务类型
                hisuser.setPatName("");//患者姓名
                hisuser.setPatSex("");// 患者性别
                hisuser.setPatHisId(user.getPatHisId());//患者his系统id（卡号）
                hisuser.setTradeType(Integer.parseInt(user.getTransactionStatus())); //交易类型
                hisuser.setHospitalTradeSerialNo(user.getHisNum());// 医院交易流水号
                hisuser.setPayPlatformRefundSerialNo("");//支付平台退款流水号
                hisuser.setPayPlatformSerialNo(user.getPaymentPlatformOrderId());//支付平台流水号
                hisuser.setAcquirerCode("");//收单机构代码
                hisuser.setTollCollector("");//收费员
                hisuser.setPatIdCard("");//患者身份证号
                hisuser.setMedicareAmount(0);//统筹基金结算金额
                hisuser.setIsInsurance(2);//是否试用医保支付
                hisuser.setChannelOrderNo(user.getPsOrderId());//渠道订单号
                hisuser.setRefundChannel(Integer.parseInt("4"));//退费渠道
                hisuser.setRefundAmount(0);//退费金额
                hisuser.setRefundType(9);// 退款类型
//                hisuser.setPayTime(DateUtil.toLocalDateTime(user.getTransactionTime(),"yyyy-MM-dd HH:mm:ss.SSS"));// 缴费时间
//                if (user.getTransactionStatus().equals("2")){
//                    hisuser.setRefundTime(DateUtil.toLocalDateTime(user.getTransactionTime(),"yyyy-MM-dd HH:mm:ss.SSS")); // 退款时间
//                }
//                hisuser.setIsCheck(ReconcEnum.ISCHECK_TYPE.NO_ISCHECK.getValue());
//                Hisuser byHisOrderIdHisuser = getHisuserByHisOrderId(user.getHisNum(),user.getTransactionStatus());
                //判断是否存在

                tUserMapper.insert(hisuser);

            }
            log.info("结束同步His账单汇总，查询总数={}、更新成功={}、更新失败={}、插入成功={}、插入失败={}",data.size(),updateSuccessNum,updateFailNum,insSuccessNum,insFailNum);
        };
    }
}
