package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

/**
 * 餐品列表
 */
public class HttpFoodListBean extends CBaseResponseData
{


    /**
     * result : {"records":[{"dishesName":"宫保鸡丁盖饭套餐","mealType_dictText":"早餐","mealType":"1","dishesId":"1","dishesMoney":20,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W1.png","mealDate":"2020-10-29"},{"dishesName":"特价菜品","mealType_dictText":"早餐","mealType":"1","dishesId":"10","dishesMoney":12,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W2.png","mealDate":"2020-10-29"},{"dishesName":"牛肉面","mealType_dictText":"午餐","mealType":"2","dishesId":"11","dishesMoney":11,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W3.png","mealDate":"2020-10-29"},{"dishesName":"宫保鸡丁","mealType_dictText":"晚餐","mealType":"3","dishesId":"12","dishesMoney":10,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W4.png","mealDate":"2020-10-29"},{"dishesName":"馒头","mealType_dictText":"早餐","mealType":"1","dishesId":"13","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W5.png","mealDate":"2020-10-29"},{"dishesName":"米饭","mealType_dictText":"午餐","mealType":"2","dishesId":"14","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W6.png","mealDate":"2020-10-29"},{"dishesName":"牛肉面套餐","mealType_dictText":"午餐","mealType":"2","dishesId":"2","dishesMoney":21,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W1.png","mealDate":"2020-10-29"},{"dishesName":"特价菜品套餐","mealType_dictText":"晚餐","mealType":"3","dishesId":"3","dishesMoney":22,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W2.png","mealDate":"2020-10-29"},{"dishesName":"麻辣豆腐盖饭套餐","mealType_dictText":"早餐","mealType":"1","dishesId":"4","dishesMoney":23,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W3.png","mealDate":"2020-10-29"},{"dishesName":"酱茄子盖饭套餐","mealType_dictText":"午餐","mealType":"2","dishesId":"5","dishesMoney":24,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W4.png","mealDate":"2020-10-29"},{"dishesName":"红烧狮子头套餐","mealType_dictText":"晚餐","mealType":"3","dishesId":"6","dishesMoney":25,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W5.png","mealDate":"2020-10-29"},{"dishesName":"红烧狮子头","mealType_dictText":"早餐","mealType":"1","dishesId":"7","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W6.png","mealDate":"2020-10-29"},{"dishesName":"酱茄子","mealType_dictText":"午餐","mealType":"2","dishesId":"8","dishesMoney":14,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/1.png","mealDate":"2020-10-29"},{"dishesName":"麻辣豆腐","mealType_dictText":"晚餐","mealType":"3","dishesId":"9","dishesMoney":13,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/2.png","mealDate":"2020-10-29"}],"total":14,"size":20,"current":1,"orders":[],"searchCount":true,"pages":1}
     * timestamp : 1603939000433
     */

    private ResultBean result;
    private long timestamp;

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
         * records : [{"dishesName":"宫保鸡丁盖饭套餐","mealType_dictText":"早餐","mealType":"1","dishesId":"1","dishesMoney":20,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W1.png","mealDate":"2020-10-29"},{"dishesName":"特价菜品","mealType_dictText":"早餐","mealType":"1","dishesId":"10","dishesMoney":12,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W2.png","mealDate":"2020-10-29"},{"dishesName":"牛肉面","mealType_dictText":"午餐","mealType":"2","dishesId":"11","dishesMoney":11,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W3.png","mealDate":"2020-10-29"},{"dishesName":"宫保鸡丁","mealType_dictText":"晚餐","mealType":"3","dishesId":"12","dishesMoney":10,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W4.png","mealDate":"2020-10-29"},{"dishesName":"馒头","mealType_dictText":"早餐","mealType":"1","dishesId":"13","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W5.png","mealDate":"2020-10-29"},{"dishesName":"米饭","mealType_dictText":"午餐","mealType":"2","dishesId":"14","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W6.png","mealDate":"2020-10-29"},{"dishesName":"牛肉面套餐","mealType_dictText":"午餐","mealType":"2","dishesId":"2","dishesMoney":21,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W1.png","mealDate":"2020-10-29"},{"dishesName":"特价菜品套餐","mealType_dictText":"晚餐","mealType":"3","dishesId":"3","dishesMoney":22,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W2.png","mealDate":"2020-10-29"},{"dishesName":"麻辣豆腐盖饭套餐","mealType_dictText":"早餐","mealType":"1","dishesId":"4","dishesMoney":23,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W3.png","mealDate":"2020-10-29"},{"dishesName":"酱茄子盖饭套餐","mealType_dictText":"午餐","mealType":"2","dishesId":"5","dishesMoney":24,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W4.png","mealDate":"2020-10-29"},{"dishesName":"红烧狮子头套餐","mealType_dictText":"晚餐","mealType":"3","dishesId":"6","dishesMoney":25,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W5.png","mealDate":"2020-10-29"},{"dishesName":"红烧狮子头","mealType_dictText":"早餐","mealType":"1","dishesId":"7","dishesMoney":15,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/W6.png","mealDate":"2020-10-29"},{"dishesName":"酱茄子","mealType_dictText":"午餐","mealType":"2","dishesId":"8","dishesMoney":14,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/1.png","mealDate":"2020-10-29"},{"dishesName":"麻辣豆腐","mealType_dictText":"晚餐","mealType":"3","dishesId":"9","dishesMoney":13,"dishesImg":"http://218.60.2.195:89/appdownload/dishesImg/2.png","mealDate":"2020-10-29"}]
         * total : 14
         * size : 20
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
             * mealType_dictText : 早餐
             * mealType : 1
             * dishesId : 1
             * dishesMoney : 20.0
             * dishesImg : http://218.60.2.195:89/appdownload/dishesImg/W1.png
             * mealDate : 2020-10-29
             */

            private String dishesName;
            private String mealType_dictText;
            private String mealType;
            private String dishesId;
            private double dishesMoney;
            private String dishesImg;
            private String mealDate;

            // 点餐时使用、已点该餐品的数量
            private int orderedNum;

            public String getDishesName() {
                return dishesName;
            }

            public void setDishesName(String dishesName) {
                this.dishesName = dishesName;
            }

            public String getMealType_dictText() {
                return mealType_dictText;
            }

            public void setMealType_dictText(String mealType_dictText) {
                this.mealType_dictText = mealType_dictText;
            }

            public String getMealType() {
                return mealType;
            }

            public void setMealType(String mealType) {
                this.mealType = mealType;
            }

            public String getDishesId() {
                return dishesId;
            }

            public void setDishesId(String dishesId) {
                this.dishesId = dishesId;
            }

            public double getDishesMoney() {
                return dishesMoney;
            }

            public void setDishesMoney(double dishesMoney) {
                this.dishesMoney = dishesMoney;
            }

            public String getDishesImg() {
                return dishesImg;
            }

            public void setDishesImg(String dishesImg) {
                this.dishesImg = dishesImg;
            }

            public String getMealDate() {
                return mealDate;
            }

            public void setMealDate(String mealDate) {
                this.mealDate = mealDate;
            }
        }
    }
}
