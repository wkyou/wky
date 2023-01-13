package com.wang.web.StreamTest;

import java.util.Date;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * @Author WangKanYou
 * @Date 2022/10/14 22:04
 * @描述:
 */
public class Lambda {

    public static void main(String[] args) {
        /**
         * lambda表达式主要用于内部类的使用
         * 省列规则：
         * 1、参数类型可以省列
         * 2、方法体只有一句代码时，大括号、return、唯一一句代码的分号可以省列
         * 3、方法只有一个参数时，小括号可以省列
         *
         */
      //  案例1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个线程");
            }
        }).start();
        //转为lambda表达式
        new Thread(()->{
            System.out.println("我是一个lambda表达式线程");
        }).start();

        //案例2
        int result=add(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println("相加结果为："+result);
        //转为lambda表达式
        int result1=add((left,rigth)->{
            return left+rigth;
        });
        System.out.println("相加结果为："+result1);
        //极简
        int result2=add((left, right) -> left+right);

        //案例3

        Object fun = fun((s -> s+"3"));
        System.out.println(fun);

    }
    public static int add(IntBinaryOperator operator){
        int a=10;
        int b=20;
        return operator.applyAsInt(a,b);
    }
    public static <R> R fun(Function<Integer,R> function){
        R result=function.apply(2);
        return result;
    }
}
