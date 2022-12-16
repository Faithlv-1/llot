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


    @Override
    public void run(String... args) throws Exception {
        List<TopicWithHouseDevice> topicWithHouseDeviceList = topicWithHouseDeviceService.getWithHouseDevice();
        for (TopicWithHouseDevice topicWithHouseDevice : topicWithHouseDeviceList){
            String topicName = topicWithHouseDevice.getTopicName();
            String houseName = topicWithHouseDevice.getHouseName();
            String deviceName = topicWithHouseDevice.getDeviceName();
            String typeName = topicWithHouseDevice.getTypeName();

            String clientId = houseName+"-"+deviceName+"-"+typeName;
            //todo callback生成方式待考虑
            MqttCallback mqttCallback = null;
            if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_CO2)){
                mqttCallback = new Co2Callback();
            }
            else if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_HUMIDITY)){
                mqttCallback = new HumidityCallback();
            }
            else if(typeName.equals(MqttConstant.MQTT_TYPE_NAME_TEMP)){
                mqttCallback = new TempCallback();
            }
            log.info("start creat MqttListener:{}",typeName);
            //创建Listener
            creatMqttListener(clientId,topicName,mqttCallback,mqttConfigInit);
            log.info("ok creat MqttListener:{}",typeName);
        }

    }

    private static void creatMqttListener(String clientId,String subTopic,MqttCallback mqttCallback,MqttConfigInit mqttConfigInit){
        MqttConfig myMqttConfig = mqttConfigInit.getMyMqttConfig();
        Map<String, String> login = mqttConfigInit.getLogin();

        String username = login.get(MqttConstant.LOGIN_USERNAME_KEY);
        String password = login.get(MqttConstant.LOGIN_PASSWORD_KEY);

        String broker = myMqttConfig.getMqttUrl();
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient client = new MqttClient(broker,clientId,persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            // 设置回调
            client.setCallback(mqttCallback);

            // 建立连接
            client.connect(connOpts);

            client.subscribe(subTopic);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
