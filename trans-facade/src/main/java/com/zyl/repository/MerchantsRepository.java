package com.zyl.repository;

import com.zyl.entity.Merchants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 商家数据层
 *
 * @author zyl
 */
@Repository
public interface MerchantsRepository extends JpaRepository<Merchants, Integer> {

    /**
     * 基于用户名查找商户
     *
     * @param userName 用户名
     * @return 商户
     */
    Merchants findByUserName(String userName);
}
