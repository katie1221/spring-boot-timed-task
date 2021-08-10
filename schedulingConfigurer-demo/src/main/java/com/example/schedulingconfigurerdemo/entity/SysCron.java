package com.example.schedulingconfigurerdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

/**
 * @author qzz
 */
@Data
@TableName("sys_cron")
public class SysCron implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    /**
     * cron执行表达式
     */
    @TableField("cron")
    private String cron;
}
