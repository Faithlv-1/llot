package com.faithlv.llot.mqtt.mapper;

import com.faithlv.llot.common.mapper.Co2Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Co2MapperTest {

    @Autowired
    Co2Mapper co2Mapper;

    @Test
    void test(){
        co2Mapper.selectList(null);
    }
}
