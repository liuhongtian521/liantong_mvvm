package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 *查询所有菜品 /兼职菜品搜索
 * @date 2020/10/27
 */
public class SearchDisheData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private int current;
        private int pages;
        private List<DataBeanTwo> records;
        private boolean searchCount;
        private int size;
        private int total;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public List<DataBeanTwo> getRecords() {
            return records;
        }

        public void setRecords(List<DataBeanTwo> records) {
            this.records = records;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class DataBeanTwo {
        private String amount;//已购数量
        private String dishesId;//餐品ID
        private String dishesImg;//餐品图片
        private String dishesName;//餐品名字
         private String isNew;//新品标记
        private String dishesMoney;
        private String dishesRemark;//msg
        private String avgcomment;

        public String getDishesRemark() {
            return dishesRemark;
        }

        public void setDishesRemark(String dishesRemark) {
            this.dishesRemark = dishesRemark;
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

        public String getAvgcomment() {
            return avgcomment;
        }

        public void setAvgcomment(String avgcomment) {
            this.avgcomment = avgcomment;
        }

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }
    }
}
