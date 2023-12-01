package com.askia.coremodel.datamodel.http.entities.query;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

/**
 * Create bt she:
 *菜品排行
 * @date 2020/10/27
 */
public class RankingData extends QBaseResponseData {
    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    private static class DataBean{
        private int current;
        private int pages;//
        private List<DataBeanTwo> records;
        private boolean searchCount;//
        private int size;
        private int total;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
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

    private static class DataBeanTwo{

        private String amount;//已购数量
        private String counts;//好评数量
        private String dishesId;//餐品ID
        private String dishesImg;//图片
        private String dishesName;//餐品名字
        private String goodAmount;//好评数量
        private String isNew;//新品标记

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

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }
    }
}
