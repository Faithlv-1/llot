package com.faithlv.llot.mqtt.service;


import com.faithlv.llot.common.service.MqttConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MqttConfigServiceTest {

    @Autowired
    MqttConfigService mqttConfigService;

    @Test
    void test(){
        mqttConfigService.getLast();
    }
}
