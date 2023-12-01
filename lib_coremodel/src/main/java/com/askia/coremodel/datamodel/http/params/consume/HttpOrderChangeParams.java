package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

/**
 * Create bt she:
 *
 * @date 2020/12/28
 */
public class HttpOrderChangeParams extends BaseRequestParams {
//    private String code;
    private String orderId;
    private String sn;
//    private String status;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }


}
