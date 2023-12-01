package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class HttpConsumeConfirmParams extends BaseRequestParams
{
    private String img;
    private String orderIdList;
    private String sn;
    private String code;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOrderIdList() {
        return orderIdList;
    }

    public void setOrderIdList(String orderIdList) {
        this.orderIdList = orderIdList;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
