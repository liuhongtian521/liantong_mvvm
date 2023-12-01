package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpRankTop10Bean extends BaseResponseData
{

    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : {"records":[{"dishesName":"宫保鸡丁盖饭套餐","dishesCount":"2","dishesId":"1"},{"dishesName":"红烧狮子头套餐","dishesCount":"1","dishesId":"6"},{"dishesName":"麻辣豆腐盖饭套餐","dishesCount":"1","dishesId":"4"},{"dishesName":"麻辣豆腐","dishesCount":"1","dishesId":"9"},{"dishesName":"红烧狮子头","dishesCount":"1","dishesId":"7"}],"total":5,"size":10,"current":1,"orders":[],"searchCount":true,"pages":1}
     * timestamp : 1604478935380
     */

    private boolean success;
    private String message;
    private int code;
    private ResultBean result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        /**
         * records : [{"dishesName":"宫保鸡丁盖饭套餐","dishesCount":"2","dishesId":"1"},{"dishesName":"红烧狮子头套餐","dishesCount":"1","dishesId":"6"},{"dishesName":"麻辣豆腐盖饭套餐","dishesCount":"1","dishesId":"4"},{"dishesName":"麻辣豆腐","dishesCount":"1","dishesId":"9"},{"dishesName":"红烧狮子头","dishesCount":"1","dishesId":"7"}]
         * total : 5
         * size : 10
         * current : 1
         * orders : []
         * searchCount : true
         * pages : 1
         */

        private int total;
        private int size;
        private int current;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

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

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {
            /**
             * dishesName : 宫保鸡丁盖饭套餐
             * dishesCount : 2
             * dishesId : 1
             */

            private String dishesName;
            private String dishesCount;
            private String dishesId;

            public String getDishesName() {
                return dishesName;
            }

            public void setDishesName(String dishesName) {
                this.dishesName = dishesName;
            }

            public String getDishesCount() {
                return dishesCount;
            }

            public void setDishesCount(String dishesCount) {
                this.dishesCount = dishesCount;
            }

            public String getDishesId() {
                return dishesId;
            }

            public void setDishesId(String dishesId) {
                this.dishesId = dishesId;
            }
        }
    }
}
