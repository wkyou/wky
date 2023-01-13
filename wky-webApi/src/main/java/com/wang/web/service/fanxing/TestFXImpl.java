package com.wang.web.service.fanxing;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2023/1/10 17:09
 * @描述:
 */
public class TestFXImpl<W,P> implements TestFX<W,P>{
    @Override
    public void test1(W w, P p) {
        System.out.println("第一个参数="+w);
        System.out.println("第二个参数="+p);

    }

    public static <E> List<E> show(E orderT) {
// System.out.println(orderT);
        return null;
    }

    //@Override
    //public void test1(Object o, Object o2) {
    //    System.out.println("第一个参数="+o);
    //    System.out.println("第二个参数="+o2);
    //}
}
