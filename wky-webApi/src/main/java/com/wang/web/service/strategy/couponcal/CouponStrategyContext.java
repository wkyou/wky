package com.wang.web.service.strategy.couponcal;

/**
 * @Author WangKanYou
 * @Date 2022/12/18 20:02
 * @描述:
 */
public class CouponStrategyContext<P> {

    /**
     * 优惠策略
     */
    private ICouponCal<P> couponCal;
    public CouponStrategyContext(ICouponCal<P> couponCal) {
        this.couponCal = couponCal;
    }

    public Integer calPrice(Integer price,P couponInfo){
        return this.couponCal.calPrice(price,couponInfo);
    }
}
