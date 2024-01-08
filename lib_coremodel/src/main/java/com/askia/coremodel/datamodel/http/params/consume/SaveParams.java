package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class SaveParams extends BaseRequestParams {

    private String menuId;
    private String readStartTime;
    private String readEndTime;

    public String getMenuId() {
        return menuId == null ? "" : menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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
