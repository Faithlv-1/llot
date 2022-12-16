package com.faithlv.llot.mqtt.Service.impl;

import com.faithlv.llot.mqtt.Service.TopicWithHouseDeviceService;
import com.faithlv.llot.mqtt.mapper.TopicWithHouseDeviceMapper;
import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicWithHouseDeviceImpl implements TopicWithHouseDeviceService {

    @Autowired
    TopicWithHouseDeviceMapper topicWithHouseDeviceMapper;

    @Override
    public List<TopicWithHouseDevice> getWithHouseDevice() {
       return topicWithHouseDeviceMapper.selectWithHouseDevice();
    }
}
