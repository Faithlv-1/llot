package com.faithlv.llot.common.Handler;

import cn.hutool.core.date.DateUtil;
import com.faithlv.llot.common.constant.ModelFieldConstant;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component("MPMetaObjectHandler")
public class MPMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName(ModelFieldConstant.MODEL_FIELD_CREATTIME, DateUtil.formatDateTime(new Date()),metaObject);
        this.setFieldValByName(ModelFieldConstant.MODEL_FIELD_MODIFYTIME, DateUtil.formatDateTime(new Date()),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName(ModelFieldConstant.MODEL_FIELD_MODIFYTIME,new Date(),metaObject);
    }
}
