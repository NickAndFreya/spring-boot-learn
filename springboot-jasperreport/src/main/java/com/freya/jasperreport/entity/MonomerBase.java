package com.freya.jasperreport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MonomerBase implements Serializable {
    /**
     * 单体id
     */
    private Integer testId;
    /**
     * 受检单位名称
     */
    private String inspectUnit;
    /**
     * 受检单位地址
     */
    private String unitAddress;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 受检装置名称
     */
    private String inspectObject;
    /**
     * 受检装置地址
     */
    private String objectAddress;
    /**
     * 建筑物高度
     */
    private String buildingHeight;
    /**
     * 接闪器距地面高度
     */
    private String lightningReceiverHeight;
    /**
     * 雷击史
     */
    private String lightningHistory;
    /**
     * 防雷类别
     */
    private String lightningType;
    /**
     * 测点数
     */
    private String stationNum;
    /**
     * 检测日期
     */
    private String inspectTime;
    /**
     * 检测类别
     */
    private String inspectType;
    /**
     * 防雷装置安装日期
     */
    private String lightningTime;
    /**
     * 施工跟踪检测原始记录编号
     */
    private String trackingRecordCode;
    /**
     * 本次检测原始记录编号
     */
    private String currentReportCode;
    /**
     * 前次报告编号
     */
    private String lastReportCode;
    /**
     * 主要检测设备名称编号
     */
    private String objectCode;
    /**
     * 检测依据
     */
    private String inspectAccord;

    /**
     * 备注
     */
    private String remark;
    /**
     * 主检人(检测取样员)
     */
    private String mainPerson;
    /**
     * 测试员
     */
    private String tester;
    /**
     * 受检单位现场负责人
     */
    private String responsePerson;
    /**
     * 报告编号
     */
    private String number;

}