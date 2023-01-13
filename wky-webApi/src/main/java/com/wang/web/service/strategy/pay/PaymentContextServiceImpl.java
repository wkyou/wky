package com.wang.web.service.strategy.pay;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:12
 * @描述:
 */
@Service
public class PaymentContextServiceImpl implements PaymentContextService, ApplicationContextAware {


    private static ApplicationContext applicationContext;
    /**
     * 自动注入所有具体策略实现类
     */
    @Resource
    List<PayService> payServiceList;

    /**
     * 额外定义一个不支持的渠道支付方式实现类
     */
    //@Resource(name = "NonsupportPayServiceImpl")  //可以在调用该方法之前就判断，改支付方式本系统是否支持
    //PayService nonsupportPayService;

    @Override
    public PayService getContext(String payType) {

        //if (StrUtil.isEmpty(channel)) {
        //    return nonsupportService;
        //}

        PayService payService;
        //方式 一、
        //策略实现类上都会打上 Payment 注解，并定义支付方式的值，用于适配订单的渠道值
        //payService = payServiceList.stream()
        //        .filter(f -> payType.equals(f.getClass().getAnnotation(Payment.class).value()))
        //        .findFirst()
        //        .orElse(null);

        //方式 二、
        //根据类来获取容器中的bean
        payService=getBean(PayTypeEnum.getClzType(payType));
        return payService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PaymentContextServiceImpl.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<?> clz) throws BeansException {
        return (T) applicationContext.getBean(clz);
    }
}
