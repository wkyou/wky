package com.wang.web.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author WangKanYou
 * @Date 2022/11/22 11:39
 * @描述:
 */
@Data
public class UserExcelDto {
    /**
     * 1、默认按顺序赋值
     * @ExcelProperty value和index不建议同时使用
     * value 需要全部给注解 不然会出现一些值为空，如果value重复只能给一个属性赋值（给最后注解的赋值），
     */
    @ExcelProperty(value = {"姓名"},index = 0)  //value和index不建议同时使用，
    private String name;
    private String age;
    @ExcelProperty(value = {"缴费金额"})
    private String transactionTime; //交易时间、
    @ExcelProperty(value = {"平台流水号"})
    private String paymentAmount;
    @ExcelProperty(value = {"总金额"})
    private String payType;
    @ExcelProperty(value = {"缴费渠道"})
    private String dailySettlementTime; //日结算时间
    @ExcelProperty(value = {"支付方式"})
    private String serviceChannel; //服务渠道
    @ExcelProperty(value = {"日结时间"})
    private String hisNum;
    @ExcelProperty(value = {"his流水号"})
    private String psOrderId;
    @ExcelProperty(value = {"交易流水号"})
    private String paymentPlatformOrderId;
    @ExcelProperty(value = {"操作类型(1缴费2退费)"})
    private String transactionStatus;
    @ExcelProperty(value = {"报销金额"})
    private String totalAmount;
    @ExcelProperty(value = {"退费渠道(原渠道,线下窗口)"})
    private String medicareAmount; //统筹金额
    @ExcelProperty(value = {"就诊卡号"})
    private String refundChannel;   //退费渠道
    @ExcelProperty(value = {"缴费日期"})
    private String patHisId; //就诊卡号
}
