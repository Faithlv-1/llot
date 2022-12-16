package com.faithlv.llot.mqtt.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicWithHouseDeviceMapperTest {

    @Autowired
    TopicWithHouseDeviceMapper topicWithHouseDeviceMapper;
    @Test
//    @Transactional
    void test(){
//        mqttTopicMapper.selectList(null);
        topicWithHouseDeviceMapper.selectWithHouseDevice();
    }
}
