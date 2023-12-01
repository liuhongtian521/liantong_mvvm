package com.askia.coremodel.datamodel.http.entities;

import java.io.Serializable;

public class StuInfoData extends BaseResponseData
{

    /**
     * type:0学生  1老师
     * "data": {
     * "name": "张三",
     * "accountMoney": 3273.00
     * }
     */

    private String type;
    private DataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * name : 彭于晏
         * "accountMoney": 3273.00
         */

        private String name;
        private double accountMoney;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAccountMoney() {
            return accountMoney;
        }

        public void setAccountMoney(double accountMoney) {
            this.accountMoney = accountMoney;
        }
    }
}
