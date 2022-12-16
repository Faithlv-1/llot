package com.faithlv.llot.mqtt.service;


import com.faithlv.llot.mqtt.service.MqttTopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqttTopiceServiceTest {

    @Autowired
    MqttTopicService mqttTopicService;

    @Test
    void test(){
        mqttTopicService.getWithHouseDevice();
    }
}
