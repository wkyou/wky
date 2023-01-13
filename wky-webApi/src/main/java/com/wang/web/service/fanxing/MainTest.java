package com.wang.web.service.fanxing;

import org.apache.poi.ss.formula.functions.T;

/**
 * @Author WangKanYou
 * @Date 2023/1/10 17:13
 * @描述:
 */
public class MainTest {



        public static void main(String[] args) {
        TestFX<String,Integer> testFX = new TestFXImpl();
        testFX.test1("ddd",0);
    }
}
