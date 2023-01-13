package com.wang.web.strategy;

import com.wang.web.service.strategy.couponcal.CouponStrategyContext;
import com.wang.web.service.strategy.couponcal.DiscountCouponCal;
import com.wang.web.service.strategy.couponcal.FullDiscountCouponCal;
import org.junit.jupiter.api.Test;

/**
 * @Author WangKanYou
 * @Date 2022/12/18 20:11
 * @描述:
 */
public class StrategyTest {
    @Test
    public void test1(){
        CouponStrategyContext<Integer> couponStrategyContext = new CouponStrategyContext(new DiscountCouponCal());
        Integer integer = couponStrategyContext.calPrice(12, 3);
        System.out.println(integer);
    }

    @Test
    public void test2(){
        CouponStrategyContext<Integer> couponStrategyContext = new CouponStrategyContext(new FullDiscountCouponCal());
        Integer integer = couponStrategyContext.calPrice(12, 3);
        System.out.println(integer);
    }

}
