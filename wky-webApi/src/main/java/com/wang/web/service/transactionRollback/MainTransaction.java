package com.wang.web.service.transactionRollback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author WangKanYou
 * @Date 2023/3/17 10:53
 * @描述:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MainTransaction {
    int value();//子线程数量
}
