package com.faithlv.llot.mqtt.mapper;

import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicWithHouseDeviceMapper {

    List<TopicWithHouseDevice> selectWithHouseDevice();
}
