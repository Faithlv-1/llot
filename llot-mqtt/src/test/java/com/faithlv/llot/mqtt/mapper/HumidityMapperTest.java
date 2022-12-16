package com.faithlv.llot.mqtt.mapper;

import com.faithlv.llot.common.mapper.HumidityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HumidityMapperTest {

    @Autowired
    HumidityMapper humidityMapper;

    @Test
    void test(){
        humidityMapper.selectList(null);
    }
}
