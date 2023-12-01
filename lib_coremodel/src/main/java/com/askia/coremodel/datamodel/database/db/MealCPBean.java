package com.askia.coremodel.datamodel.database.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Create bt she:
 *
 * @date 2019/11/26
 */
public class MealCPBean extends RealmObject {
    @PrimaryKey
    private String mealName;
    @Required
    private String mealImg;//目前保存网络地址，如果实在是特别的慢的话在选择优先下载本地保存

    private String mealDate;

    private String mealTime;

    private String mealConstitute;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImg() {
        return mealImg;
    }

    public void setMealImg(String mealImg) {
        this.mealImg = mealImg;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public String getMealConstitute() {
        return mealConstitute;
    }

    public void setMealConstitute(String mealConstitute) {
        this.mealConstitute = mealConstitute;
    }
}
