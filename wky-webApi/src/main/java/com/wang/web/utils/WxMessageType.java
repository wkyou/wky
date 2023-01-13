package com.wang.web.utils;

import lombok.Getter;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 10:01
 * @描述:
 */
@Getter
public enum WxMessageType {

    /**
     * 事件类型，比如订阅与取消订阅
     */
    EVENT("event"),
    /**
     * 向公众号发送的文字消息
     */
    TEXT("text");

    private String code;

    WxMessageType(String code) {
        this.code = code;
    }
}