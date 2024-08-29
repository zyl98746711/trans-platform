package com.zyl.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 商家实体类
 *
 * @author zyl
 */
@Entity
@Data
@Table(name = "u_merchants")
public class Merchants {

    /**
     * 商家id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer merchantsId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 密码盐
     */
    private String salt;


}
