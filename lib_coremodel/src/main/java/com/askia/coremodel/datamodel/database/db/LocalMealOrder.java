package com.askia.coremodel.datamodel.database.db;

import com.askia.coremodel.datamodel.http.entities.consume.OrderResultInfo;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LocalMealOrder extends RealmObject implements Serializable {
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

    private String orderDetailJsonInfo;

    private String mealStartTime;
    private String mealEndTime;
    private String cardNo;
//    private String orderType;
//    private String orderTime;

//    public String getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(String orderType) {
//        this.orderType = orderType;
//    }
//
//    public String getOrderTime() {
//        return orderTime;
//    }
//
//    public void setOrderTime(String orderTime) {
//        this.orderTime = orderTime;
//    }

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

    public String getOrderDetailJsonInfo() {
        return orderDetailJsonInfo;
    }

    public void setOrderDetailJsonInfo(String orderDetailJsonInfo) {
        this.orderDetailJsonInfo = orderDetailJsonInfo;
    }
}
