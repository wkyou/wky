package com.wang.web.service.strategy.pay;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 16:16
 * @描述:
 */
public enum  PayTypeEnum {
    WECHAT("wechat",WechatPayServiceImpl.class),
    ALIPAY("alipay",AlipayServiceImpl.class);

    private String payType;
    private Class clz;

    PayTypeEnum(String payType, Class clz) {
        this.payType = payType;
        this.clz = clz;
    }
    public static Class getClzType(String payType){
        for (PayTypeEnum value : PayTypeEnum.values()) {
            if (value.payType.equals(payType)) {
                return value.clz;
            }
        }
        return null;
    }
}
