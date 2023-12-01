package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.entities.consume.OrderResultInfo;

public class GetFoodResultEvent {
    //  0 人脸库中没有该人脸 1 没有查到订单 2 查到了订单 3 主屏已出理  客屏继续点餐  6选择人脸
    private int code;
    private OrderResultInfo orderResult;

    public OrderResultInfo getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(OrderResultInfo orderResult) {
        this.orderResult = orderResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
