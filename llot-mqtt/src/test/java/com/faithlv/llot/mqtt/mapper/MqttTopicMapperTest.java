package com.faithlv.llot.mqtt.mapper;

import com.faithlv.llot.common.mapper.MqttTopicMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqttTopicMapperTest {

    @Autowired
    MqttTopicMapper mqttTopicMapper;

    @Test
    void test(){
        mqttTopicMapper.selectList(null);
    }
}
