package com.askia.coremodel.datamodel.database.db.consume;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OrderResultInfoDB extends RealmObject {

    @PrimaryKey
    private String orderId;
    private String orderInfo;
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
