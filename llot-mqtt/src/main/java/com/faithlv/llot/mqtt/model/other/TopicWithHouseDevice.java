package com.faithlv.llot.mqtt.model.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    todo 包位置待确定
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicWithHouseDevice {

    /**
     * 主题名称
     */
    private String topicName;

    /**
     * 房子名字
     */
    private String houseName;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 类型名称
     */
    private String typeName;
}
