package com.faithlv.llot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faithlv.llot.common.mapper.MqttTopicMapper;
import com.faithlv.llot.common.model.po.MqttTopic;
import com.faithlv.llot.common.service.MqttTopicService;
import org.springframework.stereotype.Service;

@Service
public class MqttTopicServiceImpl extends ServiceImpl<MqttTopicMapper, MqttTopic> implements MqttTopicService {


}
