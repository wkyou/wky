package com.wang.web.service.strategy.couponcal;

/**
 * @Author WangKanYou
 * @Date 2022/12/18 19:54
 * @描述:
 */
public class DiscountCouponCal implements ICouponCal<Integer> {
    @Override
    public Integer calPrice(Integer price, Integer couponInfo) {
        return price * couponInfo;
    }
}
