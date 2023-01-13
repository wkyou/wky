package com.wang.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatis-plus自动生成
 * @since 2022-11-26
 */
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 缴费状态
     */
    private Integer paymentStatus;

    /**
     * 医保单据号
     */
    private String insuranceDocumentNo;

    /**
     * 医保撤销流水号
     */
    private String insuranceRefundSerialNo;

    /**
     * 医保流水号
     */
    private String insuranceSerialNumber;

    /**
     * 个人账户结算金额
     */
    private Integer accountAmount;

    /**
     * 付款金额
     */
    private Integer payAmount;

    /**
     * 总金额
     */
    private Integer totalAmount;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 服务渠道
     */
    private String serviceChannel;

    /**
     * 创建订单时间
     */
    private LocalDateTime createTime;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 患者姓名
     */
    private String patName;

    /**
     * 患者性别
     */
    private String patSex;

    /**
     * 患者his系统id（卡号）
     */
    private String patHisId;

    /**
     * 交易类型
     */
    private Integer tradeType;

    /**
     * 医院交易流水号
     */
    private String hospitalTradeSerialNo;

    /**
     * 支付平台退款流水号
     */
    private String payPlatformRefundSerialNo;

    /**
     * 支付平台流水号
     */
    private String payPlatformSerialNo;

    /**
     * 收单机构代码
     */
    private String acquirerCode;

    /**
     * 收费员
     */
    private String tollCollector;

    /**
     * 患者身份证号
     */
    private String patIdCard;

    /**
     * 统筹基金结算金额
     */
    private Integer medicareAmount;

    /**
     * 是否试用医保支付
     */
    private Integer isInsurance;

    /**
     * 渠道订单号
     */
    private String channelOrderNo;

    /**
     * 退费渠道
     */
    private Integer refundChannel;

    /**
     * 退费金额
     */
    private Integer refundAmount;

    /**
     * 退款类型
     */
    private Integer refundType;

    /**
     * 缴费时间
     */
    private LocalDateTime payTime;

    /**
     * 退款时间
     */
    private LocalDateTime refundTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 是否核验 1=已核验 0=未核验
     */
    private Integer isCheck;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getInsuranceDocumentNo() {
        return insuranceDocumentNo;
    }

    public void setInsuranceDocumentNo(String insuranceDocumentNo) {
        this.insuranceDocumentNo = insuranceDocumentNo;
    }

    public String getInsuranceRefundSerialNo() {
        return insuranceRefundSerialNo;
    }

    public void setInsuranceRefundSerialNo(String insuranceRefundSerialNo) {
        this.insuranceRefundSerialNo = insuranceRefundSerialNo;
    }

    public String getInsuranceSerialNumber() {
        return insuranceSerialNumber;
    }

    public void setInsuranceSerialNumber(String insuranceSerialNumber) {
        this.insuranceSerialNumber = insuranceSerialNumber;
    }

    public Integer getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Integer accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getServiceChannel() {
        return serviceChannel;
    }

    public void setServiceChannel(String serviceChannel) {
        this.serviceChannel = serviceChannel;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatSex() {
        return patSex;
    }

    public void setPatSex(String patSex) {
        this.patSex = patSex;
    }

    public String getPatHisId() {
        return patHisId;
    }

    public void setPatHisId(String patHisId) {
        this.patHisId = patHisId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public String getHospitalTradeSerialNo() {
        return hospitalTradeSerialNo;
    }

    public void setHospitalTradeSerialNo(String hospitalTradeSerialNo) {
        this.hospitalTradeSerialNo = hospitalTradeSerialNo;
    }

    public String getPayPlatformRefundSerialNo() {
        return payPlatformRefundSerialNo;
    }

    public void setPayPlatformRefundSerialNo(String payPlatformRefundSerialNo) {
        this.payPlatformRefundSerialNo = payPlatformRefundSerialNo;
    }

    public String getPayPlatformSerialNo() {
        return payPlatformSerialNo;
    }

    public void setPayPlatformSerialNo(String payPlatformSerialNo) {
        this.payPlatformSerialNo = payPlatformSerialNo;
    }

    public String getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(String acquirerCode) {
        this.acquirerCode = acquirerCode;
    }

    public String getTollCollector() {
        return tollCollector;
    }

    public void setTollCollector(String tollCollector) {
        this.tollCollector = tollCollector;
    }

    public String getPatIdCard() {
        return patIdCard;
    }

    public void setPatIdCard(String patIdCard) {
        this.patIdCard = patIdCard;
    }

    public Integer getMedicareAmount() {
        return medicareAmount;
    }

    public void setMedicareAmount(Integer medicareAmount) {
        this.medicareAmount = medicareAmount;
    }

    public Integer getIsInsurance() {
        return isInsurance;
    }

    public void setIsInsurance(Integer isInsurance) {
        this.isInsurance = isInsurance;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public Integer getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(Integer refundChannel) {
        this.refundChannel = refundChannel;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public LocalDateTime getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(LocalDateTime refundTime) {
        this.refundTime = refundTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "TUser{" +
        "id=" + id +
        ", paymentStatus=" + paymentStatus +
        ", insuranceDocumentNo=" + insuranceDocumentNo +
        ", insuranceRefundSerialNo=" + insuranceRefundSerialNo +
        ", insuranceSerialNumber=" + insuranceSerialNumber +
        ", accountAmount=" + accountAmount +
        ", payAmount=" + payAmount +
        ", totalAmount=" + totalAmount +
        ", payType=" + payType +
        ", serviceChannel=" + serviceChannel +
        ", createTime=" + createTime +
        ", businessType=" + businessType +
        ", patName=" + patName +
        ", patSex=" + patSex +
        ", patHisId=" + patHisId +
        ", tradeType=" + tradeType +
        ", hospitalTradeSerialNo=" + hospitalTradeSerialNo +
        ", payPlatformRefundSerialNo=" + payPlatformRefundSerialNo +
        ", payPlatformSerialNo=" + payPlatformSerialNo +
        ", acquirerCode=" + acquirerCode +
        ", tollCollector=" + tollCollector +
        ", patIdCard=" + patIdCard +
        ", medicareAmount=" + medicareAmount +
        ", isInsurance=" + isInsurance +
        ", channelOrderNo=" + channelOrderNo +
        ", refundChannel=" + refundChannel +
        ", refundAmount=" + refundAmount +
        ", refundType=" + refundType +
        ", payTime=" + payTime +
        ", refundTime=" + refundTime +
        ", lastUpdateTime=" + lastUpdateTime +
        ", isCheck=" + isCheck +
        "}";
    }
}
