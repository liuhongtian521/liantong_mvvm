package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpWorkbenchStatisticsBean extends BaseResponseData {

    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : [{"mealDate":"2020-11-03","mealType":"1","sumMoney":"300.00","sumMoneyOnline":"147.00","sumMoneyOffline":"153.00","amount":"9"},{"mealDate":"2020-11-03","mealType":"2","sumMoney":"1052.00","sumMoneyOnline":"1052.00","sumMoneyOffline":"0.00","amount":"18"},{"mealDate":"2020-11-03","mealType":"3","sumMoney":"402.00","sumMoneyOnline":"402.00","sumMoneyOffline":"0.00","amount":"14"}]
     * timestamp : 1604402258900
     */

    private boolean success;
    private String message;
    private int code;
    private long timestamp;
    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        private String todayRefundNum;//退款
        private String todayRefundMoney;
        private String todayNum;//总计
        private String todayMoney;

        public String getTodayRefundNum() {
            return todayRefundNum;
        }

        public void setTodayRefundNum(String todayRefundNum) {
            this.todayRefundNum = todayRefundNum;
        }

        public String getTodayRefundMoney() {
            return todayRefundMoney;
        }

        public void setTodayRefundMoney(String todayRefundMoney) {
            this.todayRefundMoney = todayRefundMoney;
        }

        public String getTodayNum() {
            return todayNum;
        }

        public void setTodayNum(String todayNum) {
            this.todayNum = todayNum;
        }

        public String getTodayMoney() {
            return todayMoney;
        }

        public void setTodayMoney(String todayMoney) {
            this.todayMoney = todayMoney;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "todayRefundNum='" + todayRefundNum + '\'' +
                    ", todayRefundMoney='" + todayRefundMoney + '\'' +
                    ", todayNume='" + todayNum + '\'' +
                    ", todayMoney='" + todayMoney + '\'' +
                    '}';
        }
    }
}
