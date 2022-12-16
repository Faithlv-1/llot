package com.faithlv.llot.common.model.po;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Co2 {

    /**
     * 二氧化碳id
     */
    @TableId(type = IdType.AUTO)
    private Integer co2Id;

    /**
     * 二氧化碳数据
     */
    private Double co2Data;

    /**
     * 房子id
     */
    private Integer houseId;

    /**
     * 设备id
     */
    private Integer deviceId;

    /**
     * 创造时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String creatTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifyTime;
}
