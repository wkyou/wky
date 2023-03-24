package com.wang.payment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 16:28
 * @描述:
 */
@Component
@ConfigurationProperties(prefix = "payconfig.aliconfig")
@Data
public class ZfbPayConfig {
    private String appId;
    private String appPrivateKey;
    private String appPublicKey;
    private String scopeType;
    private String aliPublicKey;
    private String url;
    private String charset;
    private String format;
    private String signType;
    private String storeId;
}