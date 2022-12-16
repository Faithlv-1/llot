package com.faithlv.llot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faithlv.llot.common.mapper.HumidityMapper;
import com.faithlv.llot.common.model.po.Humidity;
import com.faithlv.llot.common.service.HumidityService;
import org.springframework.stereotype.Service;

@Service
public class HumidityServiceImpl extends ServiceImpl<HumidityMapper, Humidity> implements HumidityService {
}
