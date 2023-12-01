package com.askia.coremodel.datamodel.http.entities.query;


import java.util.List;

/**
 * Create bt she:
 *每周菜谱/订单
 * @date 2020/10/28
 */
public class WeekOrderData extends QBaseResponseData {

    private List<DataBean> result;

    public List<DataBean> getResult() {
        return result;
    }

    public void setResult(List<DataBean> result) {
        this.result = result;
    }

    public static class DataBean{

        private String mealDate;//用餐日期
        private String mealType;//类型
        private String windowId;//窗口ID
        private String windowName;//窗口名称
        private List<DataBeanTwo> dishesList;//餐品列表

        public String getMealDate() {
            return mealDate;
        }

        public void setMealDate(String mealDate) {
            this.mealDate = mealDate;
        }

        public String getMealType() {
            return mealType;
        }

        public void setMealType(String mealType) {
            this.mealType = mealType;
        }

        public String getWindowId() {
            return windowId;
        }

        public void setWindowId(String windowId) {
            this.windowId = windowId;
        }

        public String getWindowName() {
            return windowName;
        }

        public void setWindowName(String windowName) {
            this.windowName = windowName;
        }

        public List<DataBeanTwo> getDishesList() {
            return dishesList;
        }

        public void setDishesList(List<DataBeanTwo> dishesList) {
            this.dishesList = dishesList;
        }
    }

    public static class DataBeanTwo{
        private String amount;//已购数量
        private String counts;//好评数量
        private String dishesId;//餐品ID
        private String dishesImg;//餐品图片
        private String dishesName;//餐品名称
        private String goodAmount;//好评数量
        private String dishesMoney;//金额

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCounts() {
            return counts;
        }

        public void setCounts(String counts) {
            this.counts = counts;
        }

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesImg() {
            return dishesImg;
        }

        public void setDishesImg(String dishesImg) {
            this.dishesImg = dishesImg;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getGoodAmount() {
            return goodAmount;
        }

        public void setGoodAmount(String goodAmount) {
            this.goodAmount = goodAmount;
        }

    }
}
