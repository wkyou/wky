package com.wang.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author WangKanYou
 * @Date 2022/8/17 11:22
 * @描述:
 */
/**
 * METHOD:用于描述方法
 *  PACKAGE:用于描述包
 * PARAMETER:用于描述方法变量
 * TYPE:用于描述类、接口或enum类型·FILE:用于描述字段(bean类字段)
 */

/**
 * SOURCE:在源文件中有效，编译过程中会被忽略
 * CLASS:随源文件一起编译在class文件中，运行时忽略
 * RUNTIME:在运行时有效，只有定义为RetentionPolicyRUNTIME时，我们才能通过注解反射获取到注解。
 */
@Target(value = {ElementType.PARAMETER, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AvoidRepeatSubmit {
    int expire() default 3;
}
