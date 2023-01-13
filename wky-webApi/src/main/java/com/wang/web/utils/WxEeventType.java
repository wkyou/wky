package com.wang.web.utils;

import lombok.Getter;

/**
 * @Author WangKanYou
 * @Date 2022/7/22 10:01
 * @描述:
 */
@Getter
public enum WxEeventType {
    /**
     * 关注公众号
     */
    SUBSCRIBE("subscribe"),
    /**
     * 取消关注公众号
     */
    UNSUBSCRIBE("unsubscribe");

    private String code;

    WxEeventType(String code) {
        this.code = code;
    }
}