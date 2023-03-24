package com.wang.payment.bean.response;

import lombok.Data;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 15:46
 * @描述:
 */
@Data
public class BusResult<T> {
    private String resultCode = "";
    private String resultMessage = "";

    private T result;
}
