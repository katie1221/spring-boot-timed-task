package com.example.schedulingconfigurerdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schedulingconfigurerdemo.entity.SysCron;
import org.springframework.stereotype.Repository;

/**
 * @author qzz
 */
@Repository
public interface CronMapper extends BaseMapper<SysCron> {
}
