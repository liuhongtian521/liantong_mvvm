package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.params.consume.HttpOfflineOrderParams;

public class RefreshOrderUIEvent  {
    private HttpOfflineOrderParams.OrderDetailInfoBean food;
    private boolean isAdd;

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }


    public HttpOfflineOrderParams.OrderDetailInfoBean getFood() {
        return food;
    }

    public void setFood(HttpOfflineOrderParams.OrderDetailInfoBean food) {
        this.food = food;
    }
}
