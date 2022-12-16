package com.faithlv.llot.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faithlv.llot.common.mapper.TempMapper;
import com.faithlv.llot.common.model.po.Temp;
import com.faithlv.llot.common.service.TempService;
import org.springframework.stereotype.Service;

@Service
public class TempServiceImpl extends ServiceImpl<TempMapper, Temp> implements TempService {
}
