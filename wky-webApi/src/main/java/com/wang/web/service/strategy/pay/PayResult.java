package com.wang.web.service.strategy.pay;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:51
 * @描述:
 */
@Data
public class PayResult<T> {
    private String resultCode = "";
    private String resultMessage = "";
    private T result;


    public static class Build{
        public static <T> PayResult<T> success(T data,String msg){
            PayResult<T> payResult = new PayResult<>();
            payResult.setResultCode("00");
            payResult.setResultMessage(msg);
            payResult.setResult(data);
            return payResult;
        }

        public static <T> PayResult<T> success(String msg){
            PayResult<T> payResult = new PayResult<>();
            payResult.setResultCode("00");
            payResult.setResultMessage(msg);
            return payResult;
        }

        public static <T> PayResult<T> error(String msg){
            PayResult<T> payResult = new PayResult<>();
            payResult.setResultCode("-1");
            payResult.setResultMessage(msg);
            return payResult;
        }

    }



}
