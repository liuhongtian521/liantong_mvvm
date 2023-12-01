package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 * 用餐记录
 *
 * @date 2020/10/28
 */
public class MealRecordData extends QBaseResponseData {
    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private int total;
        private int size;
        private int current;
        private boolean searchCount;
        private int pages;
        private List<DataBeanTwo> records;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<DataBeanTwo> getRecords() {
            return records;
        }

        public void setRecords(List<DataBeanTwo> records) {
            this.records = records;
        }
    }

    public static class DataBeanTwo {
        private String consumed;//是否已被消费
        private String orderNo;//订单号
        private String orderMoney;//订单金额
        private String consumeType_dictText;
        private String mealType;//餐次
        private String mealType_dictText;//
        private String consumed_dictText;//
        private String studentName;//
        private String mealDate;//日期
        private String consumeType;//消费类型
        private String windowName;//窗口名字

        public String getWindowName() {
            return windowName;
        }

        public void setWindowName(String windowName) {
            this.windowName = windowName;
        }

        private List<DataBeanThree> dishesList;

        public List<DataBeanThree> getDishesList() {
            return dishesList;
        }

        public void setDishesList(List<DataBeanThree> dishesList) {
            this.dishesList = dishesList;
        }

        public String getConsumed() {
            return consumed;
        }

        public void setConsumed(String consumed) {
            this.consumed = consumed;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderMoney() {
            return orderMoney;
        }

        public void setOrderMoney(String orderMoney) {
            this.orderMoney = orderMoney;
        }

        public String getConsumeType_dictText() {
            return consumeType_dictText;
        }

        public void setConsumeType_dictText(String consumeType_dictText) {
            this.consumeType_dictText = consumeType_dictText;
        }

        public String getMealType() {
            return mealType;
        }

        public void setMealType(String mealType) {
            this.mealType = mealType;
        }

        public String getMealType_dictText() {
            return mealType_dictText;
        }

        public void setMealType_dictText(String mealType_dictText) {
            this.mealType_dictText = mealType_dictText;
        }

        public String getConsumed_dictText() {
            return consumed_dictText;
        }

        public void setConsumed_dictText(String consumed_dictText) {
            this.consumed_dictText = consumed_dictText;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getMealDate() {
            return mealDate;
        }

        public void setMealDate(String mealDate) {
            this.mealDate = mealDate;
        }

        public String getConsumeType() {
            return consumeType;
        }

        public void setConsumeType(String consumeType) {
            this.consumeType = consumeType;
        }
    }

    public static class DataBeanThree {
        private String dishesName;//餐品名称
        private String amount;//数量
        private String dishesMoney;//

        private String orderStatus_text;
        private String orderStatus;

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getOrderStatus_text() {
            return orderStatus_text;
        }

        public void setOrderStatus_text(String orderStatus_text) {
            this.orderStatus_text = orderStatus_text;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }
    }
}
