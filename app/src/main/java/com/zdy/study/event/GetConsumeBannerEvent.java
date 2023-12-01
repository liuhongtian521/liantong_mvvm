package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeBannerBean;

public class GetConsumeBannerEvent {
    private HttpConsumeBannerBean bean;

    public HttpConsumeBannerBean getBean() {
        return bean;
    }

    public void setBean(HttpConsumeBannerBean bean) {
        this.bean = bean;
    }
}
