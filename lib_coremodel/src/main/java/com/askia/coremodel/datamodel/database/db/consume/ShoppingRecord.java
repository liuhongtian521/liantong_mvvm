package com.askia.coremodel.datamodel.database.db.consume;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 学生超市消费记录表
 */
public class ShoppingRecord extends RealmObject{
    @PrimaryKey
    private String uuid;
    // 学号
    private String stuNo;
    // 卡号
    private String cardCode;
    // 学生姓名
    private String stuName;
    // 时间戳
    private long timeStamp;
    // 退款时间
    private long refundTime;
    // 金额
    private String money;
    // 订单状态  与后端orderStatus同步  2已消费 3 退订中 4 已退订 5 部分退订
    private String orderStatus;
    // 同步状态 0 未同步  1已同步
    private String syncStatus;


    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getRefundUser() {
        return refundUser;
    }

    public void setRefundUser(String refundUser) {
        this.refundUser = refundUser;
    }

    //下单人信息
    private String orderUser;
    //退单人信息
    private String refundUser;

    public long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(long refundTime) {
        this.refundTime = refundTime;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
