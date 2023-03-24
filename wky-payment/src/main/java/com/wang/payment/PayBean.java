package com.wang.payment;

import com.wang.payment.config.ZfbPayConfig;
import com.wang.payment.config.WxPayConfig;
import com.wang.payment.payapi.AlipayServiceImpl;
import com.wang.payment.payapi.WechatPayServiceImpl;
import com.wang.payment.service.impl.PayServiceApiImpl;
import com.wang.payment.service.impl.PaymentContextServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 15:22
 * @描述:
 */
@Component
public class PayBean {

    /**---------------------------------加载支付初始化配置参数--------------------------------*/
    @Bean
    public WxPayConfig getWxPayConfig(){
        return new WxPayConfig();
    }

    @Bean
    public ZfbPayConfig getAlipayConfig(){
        return new ZfbPayConfig();
    }


    @Bean
    public AlipayServiceImpl getAlipayServiceImpl(ZfbPayConfig zfbPayConfig){
        return new AlipayServiceImpl(zfbPayConfig);
    }
    @Bean
    public WechatPayServiceImpl getWechatPayServiceImpl(WxPayConfig wxPayConfig){
        return new WechatPayServiceImpl(wxPayConfig);
    }

    @Bean
    public PaymentContextServiceImpl getPaymentContextServiceImpl(){
        return new PaymentContextServiceImpl();
    }

    @Bean
    public PayServiceApiImpl getPayServiceApiImpl(){
        return new PayServiceApiImpl();
    }

}
