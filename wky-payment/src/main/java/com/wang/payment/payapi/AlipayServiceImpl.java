package com.wang.payment.payapi;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.wang.payment.annotation.Payment;
import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;
import com.wang.payment.config.ZfbPayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:36
 * @描述:
 */
@Slf4j
@Service
@Payment("alipay")
public class AlipayServiceImpl implements PayService{
    private ZfbPayConfig zfbPayConfig;

    private AlipayClient alipayClient;
    public AlipayServiceImpl(ZfbPayConfig zfbPayConfig){
        //支付宝初始化
        this.zfbPayConfig = zfbPayConfig;
        AlipayConfig alipayConfig = new AlipayConfig();
        //设置网关地址
        alipayConfig.setServerUrl(zfbPayConfig.getUrl());
        //设置应用ID
        alipayConfig.setAppId(zfbPayConfig.getAppId());
        //设置应用私钥
        alipayConfig.setPrivateKey(zfbPayConfig.getAppPrivateKey());
        //设置请求格式，固定值json
        alipayConfig.setFormat(zfbPayConfig.getFormat());
        //设置字符集
        alipayConfig.setCharset(zfbPayConfig.getCharset());
        //设置签名类型
        alipayConfig.setSignType(zfbPayConfig.getSignType());
        //设置支付宝公钥
        alipayConfig.setAlipayPublicKey(zfbPayConfig.getAliPublicKey());
        //实例化客户端
        try {
            alipayClient = new DefaultAlipayClient(alipayConfig);
        } catch (AlipayApiException e) {
            log.info("支付宝初始化错误，请检查初始化参数是否正确");
            e.printStackTrace();
        }
    }

    @Override
    public BusResult unifiedOrderApplet(PayOrder payOrder) {
        String msg="这里是支付宝下单支付接口，你支付的金额为："+"---zfb8";
        return null;
    }

    @Override
    public BusResult unifiedOrderH5(PayOrder payOrder) {
        return null;
    }

    @Override
    public BusResult unifiedOrderPC(PayOrder payOrder) {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "MZJF2023031601058P");
        bizContent.put("total_amount", 0.01);
        bizContent.put("subject", "测试门诊缴费");
        request.setBizContent(bizContent.toString());
        AlipayTradePrecreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.info("支付宝调用下单接口错误");
            e.printStackTrace();
        }
        if(response.isSuccess()){
            log.info("调用成功");
            log.info("支付宝订单号"+response.getOutTradeNo());
            log.info("付款码url"+response.getQrCode());
        } else {
            log.info("调用支付宝下单接口失败");
        }
        BusResult<Object> objectBusResult = new BusResult<>();
        objectBusResult.setResult(response);
        return objectBusResult;
    }

    @Override
    public BusResult orderQuery(OrderQueryParam orderQueryParam) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "MZJF2023031601058P");
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response=null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.info("支付宝调用下单接口错误");
            e.printStackTrace();
        }
        if(response.isSuccess()){
            log.info("调用成功");
        } else {
            log.info("调用支付宝下单接口失败");
        }
        BusResult<Object> objectBusResult = new BusResult<>();
        objectBusResult.setResult(response);
        return objectBusResult;
    }
}
