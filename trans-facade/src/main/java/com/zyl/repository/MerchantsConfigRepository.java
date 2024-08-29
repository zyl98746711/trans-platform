package com.zyl.repository;

import com.zyl.entity.MerchantsConfig;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zyl
 */
public interface MerchantsConfigRepository extends JpaRepository<MerchantsConfig, Integer> {

    /**
     * 获取开启配置的商家
     *
     * @param syncStatus   同步状态
     * @param syncPlatform 同步平台
     * @return 配置列表
     */
    List<MerchantsConfig> findAllBySyncStatusAndSyncPlatform(Integer syncStatus, Integer syncPlatform);
}
