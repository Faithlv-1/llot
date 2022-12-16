package com.faithlv.mqtt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faithlv.mqtt.model.po.Temp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TempMapper extends BaseMapper<Temp> {
}
