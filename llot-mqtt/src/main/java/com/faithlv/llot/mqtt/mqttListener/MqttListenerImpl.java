package com.faithlv.llot.mqtt.mqttListener;

import com.faithlv.llot.common.model.po.MqttConfig;
import com.faithlv.llot.common.service.MqttConfigService;
import com.faithlv.llot.mqtt.Service.TopicWithHouseDeviceService;
import com.faithlv.llot.mqtt.constant.MqttConstant;
import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import com.faithlv.llot.mqtt.mqttCallback.Co2Callback;
import com.faithlv.llot.mqtt.mqttCallback.HumidityCallback;
import com.faithlv.llot.mqtt.mqttCallback.TempCallback;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class MqttListenerImpl implements CommandLineRunner {

    @Autowired
    MqttConfigService mqttConfigService;
    @Autowired
    MqttConfigInit mqttConfigInit;

    @Autowired
    TopicWithHouseDeviceService topicWithHouseDeviceService;

    //todo 采用常量
    @Autowired
    Co2Callback co2Callback;

    @Autowired
    HumidityCallback humidityCallback;

    @Autowired
    TempCallback tempCallback;

    @Override
    public void run(String... args) throws Exception {
        //todo 以后考虑可以添加参数的功能，不写死在代码
        ArrayList<String> co2TopicList = new ArrayList<>();
        ArrayList<String> humidityTopicList = new ArrayList<>();
        ArrayList<String> tempTopicList = new ArrayList<>();

        List<TopicWithHouseDevice> topicWithHouseDeviceList = topicWithHouseDeviceService.getWithHouseDevice();
        for (TopicWithHouseDevice topicWithHouseDevice : topicWithHouseDeviceList){
            String topicName = topicWithHouseDevice.getTopicName();
            String houseName = topicWithHouseDevice.getHouseName();
            String deviceName = topicWithHouseDevice.getDeviceName();
            String typeName = topicWithHouseDevice.getTypeName();

            //todo callback生成方式待考虑
            MqttCallback mqttCallback = null;
            if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_CO2)){
                co2TopicList.add(topicName);
            }
            else if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_HUMIDITY)){
                humidityTopicList.add(topicName);
            }
            else if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_TEMP)){
                tempTopicList.add(topicName);
            }
            else {
                log.info("未知type类型:【{}】，不创建Listener",topicName);
                return;
            }

        }

        //创建client
        MqttClient co2Client = creatMqttClient(MqttConstant.MQTT_CLIENT_ID_CO2, co2Callback, mqttConfigInit);
        MqttClient humidityClient = creatMqttClient(MqttConstant.MQTT_CLIENT_ID_HUMIDITY, humidityCallback, mqttConfigInit);
        MqttClient tempClient = creatMqttClient(MqttConstant.MQTT_CLIENT_ID_TEMP, tempCallback, mqttConfigInit);

        log.info("start creat MqttListener}");
        //创建Listener
        creatMqttListener(co2Client,co2TopicList.toArray(new String[0]));
        creatMqttListener(humidityClient,humidityTopicList.toArray(new String[0]));
        creatMqttListener(tempClient,tempTopicList.toArray(new String[0]));
        log.info("ok creat MqttListener");

    }

    private static MqttClient creatMqttClient(String clientId,MqttCallback mqttCallback,MqttConfigInit mqttConfigInit) throws MqttException {
        MqttConfig myMqttConfig = mqttConfigInit.getMyMqttConfig();
        Map<String, String> login = mqttConfigInit.getLogin();

        String username = login.get(MqttConstant.LOGIN_USERNAME_KEY);
        String password = login.get(MqttConstant.LOGIN_PASSWORD_KEY);

        String broker = myMqttConfig.getMqttUrl();
        MemoryPersistence persistence = new MemoryPersistence();

        MqttClient client = new MqttClient(broker,clientId,persistence);

        // MQTT 连接选项
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        connOpts.setAutomaticReconnect(true);
        // 保留会话
        connOpts.setCleanSession(true);
        // 设置回调
        client.setCallback(mqttCallback);
        // 建立连接
        client.connect(connOpts);
        return client;

    }

    private static void creatMqttListener(MqttClient client,String[] subTopicList) throws MqttException {
        client.subscribe(subTopicList);
    }
}
