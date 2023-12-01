package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OrderResultInfo {

    /**
     * accountMoney :
     * className :
     * consumeType :
     * consumed :
     * mealDate :
     * mealType :
     * orderDetailInfo : [{"amount":"","dishesId":"","dishesMoney":"","dishesName":"","dishesUrl":""}]
     * orderId :
     * orderMoney :
     * orderNo :
     * studentCode :
     * studentId :
     * studentName :
     * url :
     */

    private String accountMoney;
    private String className;
    private String consumeType;
    private String consumed;
    private String mealDate;
    private String mealType;
    @PrimaryKey
    private String orderId;
    private String orderMoney;
    private String orderNo;
    private String studentCode;
    private String studentId;
    private String studentName;
    private String url;
    private String localAvatarPath;
    private String mealStartTime;
    private String mealEndTime;
    private String cardNo;
    private String msg;
    private Boolean isOffline;

    public Boolean getOffline() {
        return isOffline;
    }

    public void setOffline(Boolean offline) {
        isOffline = offline;
    }

    //    private String getOrderType;

//    public String getGetOrderType() {
//        return getOrderType;
//    }
//
//    public void setGetOrderType(String getOrderType) {
//        this.getOrderType = getOrderType;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMealStartTime() {
        return mealStartTime;
    }

    public void setMealStartTime(String mealStartTime) {
        this.mealStartTime = mealStartTime;
    }

    public String getMealEndTime() {
        return mealEndTime;
    }

    public void setMealEndTime(String mealEndTime) {
        this.mealEndTime = mealEndTime;
    }

    public String getLocalAvatarPath() {
        return localAvatarPath;
    }

    public void setLocalAvatarPath(String localAvatarPath) {
        this.localAvatarPath = localAvatarPath;
    }

    private List<OrderDetailInfoBean> orderDetailInfo;

    public String getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(String accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public String getConsumed() {
        return consumed;
    }

    public void setConsumed(String consumed) {
        this.consumed = consumed;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<OrderDetailInfoBean> getOrderDetailInfo() {
        return orderDetailInfo;
    }

    public void setOrderDetailInfo(List<OrderDetailInfoBean> orderDetailInfo) {
        this.orderDetailInfo = orderDetailInfo;
    }


    @Override
    public String toString() {
        return "OrderResultInfo{" +
                "accountMoney='" + accountMoney + '\'' +
                ", className='" + className + '\'' +
                ", consumeType='" + consumeType + '\'' +
                ", consumed='" + consumed + '\'' +
                ", mealDate='" + mealDate + '\'' +
                ", mealType='" + mealType + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderMoney='" + orderMoney + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", url='" + url + '\'' +
                ", localAvatarPath='" + localAvatarPath + '\'' +
                ", mealStartTime='" + mealStartTime + '\'' +
                ", mealEndTime='" + mealEndTime + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", msg='" + msg + '\'' +
                ", orderDetailInfo=" + orderDetailInfo +
                '}';
    }

    public static class OrderDetailInfoBean {
        /**
         * amount :
         * dishesId :
         * dishesMoney :
         * dishesName :
         * dishesUrl :
         */

        private String amount;
        private String dishesId;
        private String dishesMoney;
        private String dishesName;
        private String dishesUrl;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getDishesUrl() {
            return dishesUrl;
        }

        public void setDishesUrl(String dishesUrl) {
            this.dishesUrl = dishesUrl;
        }
    }
}
