package com.faithlv.mqtt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faithlv.mqtt.model.po.MqttConfig;

public interface MqttConfigService extends IService<MqttConfig> {

    MqttConfig getLast();
}
