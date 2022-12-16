package com.faithlv.llot.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faithlv.llot.common.model.po.MqttConfig;

public interface MqttConfigService extends IService<MqttConfig> {

    MqttConfig getLast();
}
