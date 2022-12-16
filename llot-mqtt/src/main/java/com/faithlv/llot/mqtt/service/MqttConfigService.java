package com.faithlv.llot.mqtt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faithlv.llot.mqtt.model.po.MqttConfig;

public interface MqttConfigService extends IService<MqttConfig> {

    MqttConfig getLast();
}
