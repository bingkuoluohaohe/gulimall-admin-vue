package com.jnu.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jnu.common.utils.PageUtils;
import com.jnu.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 20:38:25
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

