package com.faithlv.llot.mqtt.mqttListener;

import com.faithlv.llot.mqtt.model.po.MqttConfig;
import com.faithlv.llot.mqtt.service.MqttConfigService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Slf4j
@Order(value = 1)
@Data
@ConfigurationProperties(prefix = "llot.mqtt")
public class MqttConfigInit implements CommandLineRunner {

    @Autowired
    private MqttConfigService mqttConfigService;

    private MqttConfig myMqttConfig;

    private Map<String,String> login;


    @Override
    public void run(String... args) throws Exception {
        myMqttConfig = mqttConfigService.getLast();
    }
}
