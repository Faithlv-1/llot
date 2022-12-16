package com.faithlv.llot.mqtt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faithlv.llot.mqtt.model.other.TopicWithHouseDevice;
import com.faithlv.llot.mqtt.model.po.MqttTopic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MqttTopicMapper extends BaseMapper<MqttTopic>{

    List<TopicWithHouseDevice> selectWithHouseDevice();

}
