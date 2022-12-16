package com.faithlv.llot.mqtt.mqttCallback;


import cn.hutool.json.JSONUtil;
import com.faithlv.llot.common.model.po.Co2;
import com.faithlv.llot.common.service.Co2Service;
import com.faithlv.llot.mqtt.constant.MqttConstant;
import com.faithlv.llot.mqtt.model.mqtt.MqttData;
import com.faithlv.llot.mqtt.mqttListener.MqttConfigInit;
import com.faithlv.llot.mqtt.mqttListener.MqttListenerImpl;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("co2Callback")
@Slf4j
public class Co2Callback implements MqttCallback {

    @Autowired
    Co2Service co2Service;

    @Autowired
    MqttConfigInit mqttConfigInit;


    /**
     * 连接丢失
     *
     * @param throwable throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("Co2Mqtt 连接丢失");
//        log.warn("待完成重连");
        //todo 异常待处理
        try {
            MqttListenerImpl.creatMqttClient(MqttConstant.MQTT_CLIENT_ID_CO2,this,mqttConfigInit);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
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
        log.info("co2Mqtt连接成功");
        log.info("topic is {}",topic);
        MqttData mqttData = JSONUtil.toBean(new String(mqttMessage.getPayload()), MqttData.class);
        List<Co2> co2List = (List<Co2>) mqttData.getData();
        //todo 数据写入异常待考虑
        try{
            co2Service.saveBatch(co2List);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }

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
