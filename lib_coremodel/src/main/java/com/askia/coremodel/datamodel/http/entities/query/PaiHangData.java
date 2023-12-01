package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 *
 * @date 2020/11/6
 */
public class PaiHangData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private List<DataBeanTwo> records;
        private int total;
        private int size;
        private int current;
        private boolean searchCount;
        private int pages;

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
        private String dishesName;
        private String counts;
        private String dishesId;

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
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
    }
}
