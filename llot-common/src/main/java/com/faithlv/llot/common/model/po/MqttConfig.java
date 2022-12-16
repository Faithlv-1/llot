package com.faithlv.llot.common.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttConfig {

    /**
     * 配置id
     */
    @TableId(type = IdType.AUTO)
    private Integer confId;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * mqtt addr
     */
    private String mqttIp;

    /**
     * mqtt端口
     */
    private String mqttPort;

    /**
     * mqtt url
     */
    private String mqttUrl;

    /**
     * 创造时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String creatTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifyTime;


}
