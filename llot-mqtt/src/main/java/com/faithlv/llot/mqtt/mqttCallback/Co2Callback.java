package com.faithlv.llot.mqtt.mqttCallback;


import cn.hutool.json.JSONUtil;
import com.faithlv.llot.mqtt.mapper.Co2Mapper;
import com.faithlv.llot.mqtt.model.po.Co2;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Co2Callback implements MqttCallback {

    @Autowired
    Co2Mapper co2Mapper;


    /**
     * 连接丢失
     *
     * @param throwable throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("Co2Mqtt 连接丢失");
        log.warn("待完成重连");
    }

    /**
     * 消息到达
     *
     * @param s           年代
     * @param mqttMessage mqtt消息
     * @throws Exception 异常
     */
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        log.info("co2Mqtt连接成功");
        log.info("json is {}",s);
        Co2 co2 = JSONUtil.toBean(s, Co2.class);
        log.info(co2.toString());

    }

    /**
     * 交付完成
     *
     * @param iMqttDeliveryToken 我mqtt交付令牌
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("co2交付完成");
    }
}
