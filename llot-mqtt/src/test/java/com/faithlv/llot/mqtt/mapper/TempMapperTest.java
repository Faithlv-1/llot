package com.faithlv.llot.mqtt.mapper;

import com.faithlv.llot.mqtt.mapper.TempMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TempMapperTest {

    @Autowired
    TempMapper tempMapper;

    @Test
    void test(){
        tempMapper.selectList(null);
    }
}
