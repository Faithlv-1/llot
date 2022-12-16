package com.faithlv.llot.mqtt.mqttCallback;

import cn.hutool.json.JSONUtil;
import com.faithlv.llot.common.model.po.Temp;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component("tempCallback")
@Slf4j
public class TempCallback implements MqttCallback {
    /**
     * 连接丢失
     *
     * @param throwable throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("TempMqtt 连接丢失");
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
        log.info("TempMqtt连接成功");
        log.info("json is {}",s);
        Temp temp = JSONUtil.toBean(s, Temp.class);
        log.info(temp.toString());

    }

    /**
     * 交付完成
     *
     * @param iMqttDeliveryToken 我mqtt交付令牌
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("Temp交付完成");
    }
}
