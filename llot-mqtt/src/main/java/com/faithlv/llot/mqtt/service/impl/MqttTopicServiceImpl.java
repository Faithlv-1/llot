package com.faithlv.llot.mqtt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import com.faithlv.llot.mqtt.service.MqttTopicService;
import com.faithlv.llot.mqtt.mapper.MqttTopicMapper;
import com.faithlv.llot.mqtt.model.po.MqttTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MqttTopicServiceImpl extends ServiceImpl<MqttTopicMapper, MqttTopic> implements MqttTopicService {

    @Autowired
    MqttTopicMapper mqttTopicMapper;

    @Override
    public List<TopicWithHouseDevice> getWithHouseDevice() {
        return mqttTopicMapper.selectWithHouseDevice();
    }
}
