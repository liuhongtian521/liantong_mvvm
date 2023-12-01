package com.zdy.study.event;

import com.askia.coremodel.datamodel.http.entities.consume.HttpConsumeConfigBean;

public class GetConfigSuccessEvent {
    private HttpConsumeConfigBean config;

    public HttpConsumeConfigBean getConfig() {
        return config;
    }

    public void setConfig(HttpConsumeConfigBean config) {
        this.config = config;
    }
}
