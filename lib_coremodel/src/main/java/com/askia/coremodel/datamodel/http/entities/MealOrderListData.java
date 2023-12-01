package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class MealOrderListData extends BaseResponseData {
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 192843711
         * name : 张三
         * window_name : 004窗口
         * meal_name : 黑米粥
         * meal_constitute : 黑米粥
         * meal_price : 2.0
         * orderCode : EZST2019101600070
         * meal_time : 11:30-16:00
         * meal_type:"2"
         * guardianPhone:""
         * stuId
         * mealTimesId
         * cardcode
         *
         */

        private String code;
        private String cardcode;
        private String name;
        private String window_name;
        private String meal_name;
        private String meal_constitute;
        private double meal_price;
        private String orderCode;
        private String meal_time;

        private String meal_type;
        private String guardianPhone;
        private String stuId;
        private String mealTimesId;


        public String getCardcode() {
            return cardcode;
        }

        public void setCardcode(String cardcode) {
            this.cardcode = cardcode;
        }

        public String getMealTimesId() {
            return mealTimesId;
        }

        public void setMealTimesId(String mealTimesId) {
            this.mealTimesId = mealTimesId;
        }

        public String getGuardianPhone() {
            return guardianPhone;
        }

        public void setGuardianPhone(String guardianPhone) {
            this.guardianPhone = guardianPhone;
        }

        public String getStuId() {
            return stuId;
        }

        public void setStuId(String stuId) {
            this.stuId = stuId;
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

        public String getWindow_name() {
            return window_name;
        }

        public void setWindow_name(String window_name) {
            this.window_name = window_name;
        }

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }

        public String getMeal_constitute() {
            return meal_constitute;
        }

        public void setMeal_constitute(String meal_constitute) {
            this.meal_constitute = meal_constitute;
        }

        public double getMeal_price() {
            return meal_price;
        }

        public void setMeal_price(double meal_price) {
            this.meal_price = meal_price;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getMeal_time() {
            return meal_time;
        }

        public void setMeal_time(String meal_time) {
            this.meal_time = meal_time;
        }

        public String getMeal_type() {
            return meal_type;
        }

        public void setMeal_type(String meal_type) {
            this.meal_type = meal_type;
        }
    }
}
