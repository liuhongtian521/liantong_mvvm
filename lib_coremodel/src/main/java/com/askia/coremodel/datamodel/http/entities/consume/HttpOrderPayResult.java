package com.askia.coremodel.datamodel.http.entities.consume;

import android.util.Log;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpOrderPayResult extends BaseResponseData {

    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * timestamp : 1604573956256
     */

    private boolean success;
    private String message;
    private int code;
    private ResultBean result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HttpOrderPayResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class ResultBean {




        private String money;
        private String name;
        private String mes;

        private Boolean isOffline = false;

        public Boolean getOffline() {
            return isOffline;
        }

        public void setOffline(Boolean offline) {
            isOffline = offline;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMes() {
            return mes;
        }

        public void setMes(String mes) {
            this.mes = mes;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "money='" + money + '\'' +
                    ", name='" + name + '\'' +
                    ", mes='" + mes + '\'' +
                    '}';
        }
    }
}
