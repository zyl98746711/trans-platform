package com.zyl.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 商家配置类
 *
 * @author zyl
 */
@Entity
@Data
@Table(name = "u_merchants_config")
public class MerchantsConfig {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configId;

    /**
     * 商家id
     */
    private Integer merchantsId;
    /**
     * 推送URL（POST）
     */
    private String url;
    /**
     * 同步类型（商品、订单。。）
     */
    private Integer syncType;
    /**
     * 同步状态
     */
    private Integer syncStatus;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 最后同步时间
     */
    private LocalDateTime lastSyncTime;
    /**
     * 同步次数
     */
    private Long syncTimes;
    /**
     * 失败次数
     */
    private Long failTimes;
    /**
     * 同步频率（分钟）
     */
    private Integer syncRate;
    /**
     * 请求msg
     */
    private String requestMsg;
    /**
     * 响应msg
     */
    private String responseMsg;
    /**
     * 同步平台
     */
    private Long syncPlatform;

}
