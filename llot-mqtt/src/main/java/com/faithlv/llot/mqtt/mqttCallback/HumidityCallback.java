package com.faithlv.llot.mqtt.mqttCallback;

import cn.hutool.json.JSONUtil;
import com.faithlv.llot.common.model.po.Humidity;
import com.faithlv.llot.common.service.HumidityService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("humidityCallback")
@Slf4j
public class HumidityCallback implements MqttCallback {

    @Autowired
    HumidityService humidityService;

    /**
     * 连接丢失
     *
     * @param throwable throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("HumidityMqtt 连接丢失");
        log.warn("待完成重连");
    }

    /**
     * 消息到达
     *
     * @param topic       年代
     * @param mqttMessage mqtt消息
     * @throws Exception 异常
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        log.info("HumidityMqtt连接成功");
        log.info("json is {}",topic);
        //todo 这里会出现转换异常
        Humidity humidity = JSONUtil.toBean(new String(mqttMessage.getPayload()), Humidity.class);
        log.info(humidity.toString());

    }

    /**
     * 交付完成
     *
     * @param iMqttDeliveryToken 我mqtt交付令牌
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("Humidity交付完成");
    }
}
