package com.zyl.enums;

import lombok.Getter;

/**
 * 同步类型枚举
 *
 * @author zyl
 */
@Getter
public enum SyncTypeEnum {

    SYNC_GOODS(1, "同步商品"),

    SYNC_ORDER(2, "同步订单"),

    SYNC_STOCK(3, "同步库存"),

    SYNC_DELIVERY(4, "同步发货");

    private final int syncType;

    private final String syncName;


    SyncTypeEnum(int syncType, String syncName) {
        this.syncType = syncType;
        this.syncName = syncName;
    }
}
