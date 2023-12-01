package com.askia.coremodel.datamodel.database.db.consume;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 学生一卡通数据
 */
public class StudentCardInfo extends RealmObject {
    // 学号
    private String stuNo;
    // 卡号
    @PrimaryKey
    private String cardCode;
    // 学生姓名
    private String stuName;
    // 班级
    private String className;
    // 卡状态 0 正常  1 异常
    private String cardStatus;
    // 账户状态 0 正常  1 禁止消费
    private String accountStatus;

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
}
