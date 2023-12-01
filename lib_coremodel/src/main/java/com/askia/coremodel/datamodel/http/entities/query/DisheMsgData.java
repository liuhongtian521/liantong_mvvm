package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 * 菜品详情
 *
 * @date 2020/10/27
 */
public class DisheMsgData extends QBaseResponseData {
    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private String amount;//菜品数量
        private String dishesId;//餐品ID
        private String dishesMoney;//餐品价格
        private String dishesName;//餐品名字
        private String dishesImg;
        private String isNew;
        private String remark;//餐品价格
        private String dishesType;
//        private List<DataBeanTwo> foodList;//食材详情
        private List<DisheAboutData.DataBean> dishList;

        public List<DisheAboutData.DataBean> getDishList() {
            return dishList;
        }

        public String getDishesType() {
            return dishesType;
        }

        public String getDishesImg() {
            return dishesImg;
        }

        public void setDishesImg(String dishesImg) {
            this.dishesImg = dishesImg;
        }

        public void setDishesType(String dishesType) {
            this.dishesType = dishesType;
        }

        public void setDishList(List<DisheAboutData.DataBean> dishList) {
            this.dishList = dishList;
        }

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }

    public static class DataBeanTwo {

        private String content;//食材含量
        private String foodId;//食材ID
        private String foodName;//食材名称
        private String foodType;//食材类型

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFoodId() {
            return foodId;
        }

        public void setFoodId(String foodId) {
            this.foodId = foodId;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getFoodType() {
            return foodType;
        }

        public void setFoodType(String foodType) {
            this.foodType = foodType;
        }
    }

}
