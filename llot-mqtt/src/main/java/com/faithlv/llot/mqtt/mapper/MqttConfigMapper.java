package com.faithlv.llot.mqtt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faithlv.llot.mqtt.model.po.MqttConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MqttConfigMapper extends BaseMapper<MqttConfig> {
}
