package com.zyl.enums;

import lombok.Getter;

/**
 * 平台类型枚举
 *
 * @author zyl
 */
@Getter
public enum PlatformTypeEnum {


    ALIBABA(1, "阿里平台");

    /**
     * 平台值
     */
    private final int platformType;
    /**
     * 平台名称
     */
    private final String platformName;

    PlatformTypeEnum(int platformType, String platformName) {
        this.platformType = platformType;
        this.platformName = platformName;
    }
}
