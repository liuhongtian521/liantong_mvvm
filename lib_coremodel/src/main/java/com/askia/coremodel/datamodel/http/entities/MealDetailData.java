package com.askia.coremodel.datamodel.http.entities;

public class MealDetailData extends BaseResponseData
{

    /**
     * data : {"meal_name":"A套餐","remark":"丝瓜中维生素含量较高，咸鸭蛋盐量过高，高血压不易使用","meal_img":null,"level":"3.6666666666666665","meal_category":"1","meal_price":15,"food_name":"西兰花+鲤鱼","meal_constitute":"土豆+茄子+西红柿","nutritions":"植物纤维,维B,胡萝卜素,胶原蛋白"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * meal_name : A套餐
         * remark : 丝瓜中维生素含量较高，咸鸭蛋盐量过高，高血压不易使用
         * meal_img : null
         * level : 3.6666666666666665
         * meal_category : 1
         * meal_price : 15.0
         * food_name : 西兰花+鲤鱼
         * meal_constitute : 土豆+茄子+西红柿
         * nutritions : 植物纤维,维B,胡萝卜素,胶原蛋白
         */

        private String meal_name;
        private String remark;
        private String meal_img;
        private String level;
        private String meal_category;
        private double meal_price;
        private String food_name;
        private String meal_constitute;
        private String nutritions;

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getMeal_img() {
            return meal_img;
        }

        public void setMeal_img(String meal_img) {
            this.meal_img = meal_img;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMeal_category() {
            return meal_category;
        }

        public void setMeal_category(String meal_category) {
            this.meal_category = meal_category;
        }

        public double getMeal_price() {
            return meal_price;
        }

        public void setMeal_price(double meal_price) {
            this.meal_price = meal_price;
        }

        public String getFood_name() {
            return food_name;
        }

        public void setFood_name(String food_name) {
            this.food_name = food_name;
        }

        public String getMeal_constitute() {
            return meal_constitute;
        }

        public void setMeal_constitute(String meal_constitute) {
            this.meal_constitute = meal_constitute;
        }

        public String getNutritions() {
            return nutritions;
        }

        public void setNutritions(String nutritions) {
            this.nutritions = nutritions;
        }
    }
}
