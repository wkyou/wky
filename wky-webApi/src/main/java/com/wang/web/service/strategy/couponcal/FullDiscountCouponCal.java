package com.wang.web.service.strategy.couponcal;

/**
 * @Author WangKanYou
 * @Date 2022/12/18 19:55
 * @描述:
 */
public class FullDiscountCouponCal implements ICouponCal<Integer> {
    @Override
    public Integer calPrice(Integer price, Integer couponInfo) {
        return price * couponInfo * 2;
    }
}
