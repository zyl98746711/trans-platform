package com.zyl.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchants_id")
    private Integer merchantsId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    private String salt;


}
