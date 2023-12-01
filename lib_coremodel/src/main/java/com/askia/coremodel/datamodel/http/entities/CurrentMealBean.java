package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class CurrentMealBean extends BaseResponseData {

    /**
     * data : {"name":"彭于","window_name":"01餐口","meal_name":"B套餐","meal_constitute":"包子+粥+茶蛋+咸菜","meal_price":8}
     */

    private DataBean data;

    private List<DataBean> dataBeanList;

    private int index;
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<DataBean> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    public static class DataBean {
        /**
         * name : 彭于
         * window_name : 01餐口
         * meal_name : B套餐
         * meal_constitute : 包子+粥+茶蛋+咸菜
         * meal_price : 8.0
         * money:100.0
         * <p>
         * guardianPhone:
         * stuId:
         * mealTimesId:
         * code:学号
         * card:卡号
         */

        private String name;
        private String window_name;
        private String meal_name;
        private List<String> meal_constitute;
        private double meal_price;
        private double money;
        private String order_id;
        private String guardianPhone;
        private String stuId;
        private String mealTimesId;
        private String code;
        private String card;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
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

        public String getMealTimesId() {
            return mealTimesId;
        }

        public void setMealTimesId(String mealTimesId) {
            this.mealTimesId = mealTimesId;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
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

        public List<String> getMeal_constitute() {
            return meal_constitute;
        }

        public void setMeal_constitute(List<String> meal_constitute) {
            this.meal_constitute = meal_constitute;
        }

        public double getMeal_price() {
            return meal_price;
        }

        public void setMeal_price(double meal_price) {
            this.meal_price = meal_price;
        }
    }
}
