package com.askia.coremodel.datamodel.http.params;

import java.util.List;

public class UploadCosummingRecParams extends BaseRequestParams
{
    private List<String> orderList;

    public List<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<String> orderList) {
        this.orderList = orderList;
    }
}
