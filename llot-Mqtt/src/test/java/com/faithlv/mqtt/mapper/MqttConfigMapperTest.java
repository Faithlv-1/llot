package com.faithlv.mqtt.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqttConfigMapperTest {

    @Autowired
    MqttConfigMapper mqttConfigMapper;

    @Test
    void test(){
        mqttConfigMapper.selectList(null);
    }
}
