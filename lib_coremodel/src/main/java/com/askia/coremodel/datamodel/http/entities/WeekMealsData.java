package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class WeekMealsData extends BaseResponseData
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
         * window_name : 001窗口
         * meal_img : null
         * meal_date : 2019-09-16
         * meal_time : 11:00-18:00
         * meal_type : 3
         * week : 1
         * meal_name : 早餐套餐A+溜肉段
         * meal_constitute : 小米粥+咸菜+胡萝卜+香肠+溜肉段
         */

        private String name;
        private String window_name;
        private String meal_img;
        private String meal_date;
        private String meal_time;
        private String meal_type;
        private String week;
        private String meal_name;
        private String meal_constitute;

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

        public String getMeal_img() {
            return meal_img;
        }

        public void setMeal_img(String meal_img) {
            this.meal_img = meal_img;
        }

        public String getMeal_date() {
            return meal_date;
        }

        public void setMeal_date(String meal_date) {
            this.meal_date = meal_date;
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

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
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
    }
}
