package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class AddCollectionParams extends BaseRequestParams {

    private String contentParentId;
    private String struId;

    public String getContentParentId() {
        return contentParentId == null ? "" : contentParentId;
    }

    public void setContentParentId(String contentParentId) {
        this.contentParentId = contentParentId;
    }

    public String getStruId() {
        return struId == null ? "" : struId;
    }

    public void setStruId(String struId) {
        this.struId = struId;
    }
}
