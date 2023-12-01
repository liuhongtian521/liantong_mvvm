package com.askia.coremodel.datamodel.database.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MealOrderRecordBean extends RealmObject
{
    @PrimaryKey
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
