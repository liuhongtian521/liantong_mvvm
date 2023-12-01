package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.entities.consume.OrderResultInfo;

public class OrderFoodEvent
{
    // 1 开始支付 2 取消支付 3 支付完成 4 支付确认完成
    private int code;
    private OrderResultInfo info;

    public OrderResultInfo getInfo() {
        return info;
    }

    public void setInfo(OrderResultInfo info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
