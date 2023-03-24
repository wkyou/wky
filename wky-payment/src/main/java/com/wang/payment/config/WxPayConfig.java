package com.wang.payment.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author WangKanYou
 * @Date 2023/3/7 16:33
 * @描述:
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "payconfig.wxconfig")
public class WxPayConfig {

    /** 商户号 */
    private String merchantId;

    /** 商户API私钥路径 */
    private String privateKeyPath;

    /** 商户证书序列号 */
    public static String merchantSerialNumber;

    /** 商户APIV3密钥 */
    public static String apiV3key;

}
