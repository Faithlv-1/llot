package com.faithlv.llot.mqtt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faithlv.llot.mqtt.mapper.MqttConfigMapper;
import com.faithlv.llot.mqtt.model.po.MqttConfig;
import com.faithlv.llot.mqtt.service.MqttConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttConfigServiceImpl extends ServiceImpl<MqttConfigMapper, MqttConfig> implements MqttConfigService {

    @Autowired
    MqttConfigMapper mqttConfigMapper;

    @Override
    public MqttConfig getLast() {
        LambdaQueryWrapper<MqttConfig> lambdaQueryWrapper = new LambdaQueryWrapper<MqttConfig>()
                .orderByDesc(MqttConfig::getConfId)
                .last("limit 0,1");

        MqttConfig mqttConfig = mqttConfigMapper.selectOne(lambdaQueryWrapper);
        return mqttConfig;
    }
}
