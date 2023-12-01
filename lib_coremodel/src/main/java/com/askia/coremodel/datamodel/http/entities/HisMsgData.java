package com.askia.coremodel.datamodel.http.entities;

import java.io.File;
import java.util.List;

/**
 * Create bt she:
 *
 * @date 2020/9/22
 */
public class HisMsgData extends BaseResponseData {

    private List<CurrentMealBean.DataBean> dataBeanList;
    private String name;
    private String code;
    private String chuangkou;

    private String hour;
    private String min;

    private File people;

    private double money;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChuangkou() {
        return chuangkou;
    }

    public void setChuangkou(String chuangkou) {
        this.chuangkou = chuangkou;
    }

    public File getPeople() {
        return people;
    }

    public void setPeople(File people) {
        this.people = people;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<CurrentMealBean.DataBean> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<CurrentMealBean.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }


}
