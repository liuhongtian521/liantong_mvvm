package com.askia.coremodel.datamodel.database.db.consume;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * 记录每日离线产生的记录数量
 */
public class DateRecord extends RealmObject {
    // yyyy-MM-dd
    @PrimaryKey
    private String date;
    private int num;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
