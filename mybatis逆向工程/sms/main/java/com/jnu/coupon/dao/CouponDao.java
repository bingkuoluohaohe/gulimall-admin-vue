package com.jnu.coupon.dao;

import com.jnu.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 19:48:58
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
