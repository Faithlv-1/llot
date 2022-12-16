package com.faithlv.llot.mqtt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import com.faithlv.llot.mqtt.model.po.MqttTopic;

import java.util.List;

public interface MqttTopicService extends IService<MqttTopic> {

    List<TopicWithHouseDevice> getWithHouseDevice();
}
