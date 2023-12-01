package com.askia.coremodel.datamodel.http.entities.consume;

public class MultipleConsume extends CBaseResponseData {

    private String total; //全部消费记录

    private String upLoadSize;//已上传
    private String unUpLoadSize;//未上传



    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUpLoadSize() {
        return upLoadSize;
    }

    public void setUpLoadSize(String upLoadSize) {
        this.upLoadSize = upLoadSize;
    }

    public String getUnUpLoadSize() {
        return unUpLoadSize;
    }

    public void setUnUpLoadSize(String unUpLoadSize) {
        this.unUpLoadSize = unUpLoadSize;
    }

}
