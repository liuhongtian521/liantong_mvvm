package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpCommentRankBean extends BaseResponseData
{

    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : {"records":[{"dishesName":"酱茄子盖饭套餐","counts":"1.57","dishesId":"5","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W4.jpg"},{"dishesName":"宫保鸡丁盖饭套餐","counts":"1.00","dishesId":"1","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W1.jpg"},{"dishesName":"特价菜品","counts":"1.00","dishesId":"10","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W2.jpg"},{"dishesName":"牛肉面","counts":"1.00","dishesId":"11","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W3.jpg"},{"dishesName":"麻辣豆腐","counts":"1.00","dishesId":"9","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/2.jpg"}],"total":14,"size":5,"current":1,"orders":[],"searchCount":true,"pages":3}
     * timestamp : 1604481359852
     */

    private boolean success;
    private String message;
    private int code;
    private ResultBean result;
    private long timestamp;

    private String commentType;

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

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
         * records : [{"dishesName":"酱茄子盖饭套餐","counts":"1.57","dishesId":"5","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W4.jpg"},{"dishesName":"宫保鸡丁盖饭套餐","counts":"1.00","dishesId":"1","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W1.jpg"},{"dishesName":"特价菜品","counts":"1.00","dishesId":"10","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W2.jpg"},{"dishesName":"牛肉面","counts":"1.00","dishesId":"11","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/W3.jpg"},{"dishesName":"麻辣豆腐","counts":"1.00","dishesId":"9","dishesImg":"http://172.16.75.249:9000/syerzhong/dishesImg/2.jpg"}]
         * total : 14
         * size : 5
         * current : 1
         * orders : []
         * searchCount : true
         * pages : 3
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
             * dishesName : 酱茄子盖饭套餐
             * counts : 1.57
             * dishesId : 5
             * dishesImg : http://172.16.75.249:9000/syerzhong/dishesImg/W4.jpg
             */

            private String dishesName;
            private String counts;
            private String dishesId;
            private String dishesImg;

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

            public String getDishesImg() {
                return dishesImg;
            }

            public void setDishesImg(String dishesImg) {
                this.dishesImg = dishesImg;
            }
        }
    }
}
