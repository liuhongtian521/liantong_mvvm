package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.params.consume.HttpOfflineOrderParams;

import java.util.List;

// 点餐时给客户屏发送的消息
public class RefreshCPrintOrderUIEvent  {
    private List<HttpOfflineOrderParams.OrderDetailInfoBean> orderedFoodList;
    private String totalMoney;

    public List<HttpOfflineOrderParams.OrderDetailInfoBean> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(List<HttpOfflineOrderParams.OrderDetailInfoBean> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }
}
