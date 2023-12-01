package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

/**
 * 订单消费结果
 */
public class HttpOrderFormResultInfo extends CBaseResponseData {

    private List<ResultBean> result;
    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

        private String mealDate;
        private String studentName;
        private String orderId;
        private String orderMoney;//订单价格
        private String orderStatus;
        private String url;
        private String studentCode;
        private String refundTime;//退款时间
        private Boolean isOffline = false; //是否为离线订单

        public Boolean getOffline() {
            return isOffline;
        }

        public void setOffline(Boolean offline) {
            isOffline = offline;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStudentCode() {
            return studentCode;
        }

        public void setStudentCode(String studentCode) {
            this.studentCode = studentCode;
        }

        public String getRefundTime() {
            return refundTime;
        }

        public void setRefundTime(String refundTime) {
            this.refundTime = refundTime;
        }

        public String getMealDate() {
            return mealDate;
        }

        public void setMealDate(String mealDate) {
            this.mealDate = mealDate;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderMoney() {
            return orderMoney;
        }

        public void setOrderMoney(String orderMoney) {
            this.orderMoney = orderMoney;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "mealDate='" + mealDate + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", orderMoney='" + orderMoney + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", url='" + url + '\'' +
                    ", studentCode='" + studentCode + '\'' +
                    ", refundTime='" + refundTime + '\'' +
                    '}';
        }
    }


}
