package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class AddReadTimeParams extends BaseRequestParams {

    private String contentParentId;
    private String contentChildrenId;
    private String struId;
    private String readStartTime;
    private String readEndTime;

    public String getContentParentId() {
        return contentParentId == null ? "" : contentParentId;
    }

    public void setContentParentId(String contentParentId) {
        this.contentParentId = contentParentId;
    }

    public String getContentChildrenId() {
        return contentChildrenId == null ? "" : contentChildrenId;
    }

    public void setContentChildrenId(String contentChildrenId) {
        this.contentChildrenId = contentChildrenId;
    }

    public String getStruId() {
        return struId == null ? "" : struId;
    }

    public void setStruId(String struId) {
        this.struId = struId;
    }

    public String getReadStartTime() {
        return readStartTime == null ? "" : readStartTime;
    }

    public void setReadStartTime(String readStartTime) {
        this.readStartTime = readStartTime;
    }

    public String getReadEndTime() {
        return readEndTime == null ? "" : readEndTime;
    }

    public void setReadEndTime(String readEndTime) {
        this.readEndTime = readEndTime;
    }
}
