package com.wang.web.service.strategy.pay;

import java.lang.annotation.*;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:24
 * @描述:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Payment {

    String value() default "";

}