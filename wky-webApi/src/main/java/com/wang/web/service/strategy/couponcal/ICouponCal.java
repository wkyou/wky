package com.wang.web.service.strategy.couponcal;

/**
 * @Author WangKanYou
 * @Date 2022/12/18 19:38
 * @描述:
 */
public interface ICouponCal<T> {
    Integer calPrice(Integer price,T couponInfo);
}
