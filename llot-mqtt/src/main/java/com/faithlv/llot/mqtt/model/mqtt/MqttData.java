package com.faithlv.llot.mqtt.model.mqtt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * mqtt数据(上传采集数据)
 *
 * @author zhengjh
 * @date 2022/12/16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttData<T> {

    /**
     * 上传数据类型（有数据，控制类型）
     */
    private String type;

    /**
     * 房子id
     */
    private Integer houseId;

    /**
     * 设备id
     */
    private Integer deviceId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 数据
     */
    private List<T> data;

}
