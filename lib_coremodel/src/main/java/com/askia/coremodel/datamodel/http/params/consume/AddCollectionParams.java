package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class AddCollectionParams extends BaseRequestParams {

    private String contentParentId;
    private String contentChildrenId;
    private String struId;

    public String getContentChildrenId() {
        return contentChildrenId == null ? "" : contentChildrenId;
    }

    public void setContentChildrenId(String contentChildrenId) {
        this.contentChildrenId = contentChildrenId;
    }

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
