package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class ConsumeRecordData extends BaseResponseData
{
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 张靓颖
         * pay_date : 2019-09-03
         * pay_money : 10.0
         * meal_name : A套餐
         * meal_category : 午餐
         */

        private String name;
        private String pay_date;
        private double pay_money;
        private String meal_name;
        private String meal_category;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPay_date() {
            return pay_date;
        }

        public void setPay_date(String pay_date) {
            this.pay_date = pay_date;
        }

        public double getPay_money() {
            return pay_money;
        }

        public void setPay_money(double pay_money) {
            this.pay_money = pay_money;
        }

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }

        public String getMeal_category() {
            return meal_category;
        }

        public void setMeal_category(String meal_category) {
            this.meal_category = meal_category;
        }
    }
}
