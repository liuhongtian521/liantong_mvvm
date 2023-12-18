package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class MyCollectionTitleResponse {

    /**
     * code : 200
     * success : true
     * data : [{"id":"833740323652894720","struName":"精选理论","struCode":"1384060802717294593"},{"id":"834377791972573184","struName":"操作技巧","struCode":"1384698467028410369"},{"id":"834383002569015296","struName":"实践案例","struCode":"1384703677503217665"},{"id":"842399502617804800","struName":"国际视野","struCode":"INTERNATIONAL_VIEW"}]
     * msg : 操作成功
     */

    private int code;
    private boolean success;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 833740323652894720
         * struName : 精选理论
         * struCode : 1384060802717294593
         */

        private String id;
        private String struName;
        private String struCode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStruName() {
            return struName;
        }

        public void setStruName(String struName) {
            this.struName = struName;
        }

        public String getStruCode() {
            return struCode;
        }

        public void setStruCode(String struCode) {
            this.struCode = struCode;
        }
    }
}
