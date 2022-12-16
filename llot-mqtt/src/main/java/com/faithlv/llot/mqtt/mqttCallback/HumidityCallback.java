package com.faithlv.llot.mqtt.mqttCallback;

import cn.hutool.json.JSONUtil;
import com.faithlv.llot.common.model.po.Humidity;
import com.faithlv.llot.common.service.HumidityService;
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

@Component("humidityCallback")
@Slf4j
public class HumidityCallback implements MqttCallback {

    @Autowired
    HumidityService humidityService;

    @Autowired
    MqttConfigInit mqttConfigInit;


    /**
     * 连接丢失
     *
     * @param throwable throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("HumidityMqtt 连接丢失");
//        log.warn("待完成重连");
        //todo 异常待处理
        try {
            MqttListenerImpl.creatMqttClient(MqttConstant.MQTT_CLIENT_ID_HUMIDITY,this,mqttConfigInit);
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
        log.info("HumidityMqtt连接成功");
        log.info("topic is {}",topic);
        MqttData mqttData = JSONUtil.toBean(new String(mqttMessage.getPayload()), MqttData.class);
        List<Humidity> humidityList = (List<Humidity>) mqttData.getData();
        //todo 数据写入异常待考虑
        try{
            humidityService.saveBatch(humidityList);
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
        log.info("Humidity交付完成");
    }
}
