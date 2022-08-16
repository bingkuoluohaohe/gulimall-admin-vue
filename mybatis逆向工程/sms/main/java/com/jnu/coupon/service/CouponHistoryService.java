package com.jnu.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jnu.common.utils.PageUtils;
import com.jnu.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 19:48:58
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

