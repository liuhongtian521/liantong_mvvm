package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class SchoolServiceBean {


    /**
     * records : [{"hospitalServiceUrl":"http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F479b517898654a088d101a3cc7f0460c.xlsx%3FExpires%3D1702262781%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DOinFQxAM7lyhwZ3%252BZ%252BByg2BvYU4%253D","hospitalServiceType":"xlsx","hospitalServiceName":"安责险回归测试0815"}]
     * total : 1
     * size : 10
     * current : 1
     * orders : []
     * optimizeCountSql : true
     * hitCount : false
     * searchCount : true
     * pages : 1
     */

    private int total;
    private int size;
    private int current;
    private boolean optimizeCountSql;
    private boolean hitCount;
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

    public boolean isOptimizeCountSql() {
        return optimizeCountSql;
    }

    public void setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
    }

    public boolean isHitCount() {
        return hitCount;
    }

    public void setHitCount(boolean hitCount) {
        this.hitCount = hitCount;
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
         * hospitalServiceUrl : http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F479b517898654a088d101a3cc7f0460c.xlsx%3FExpires%3D1702262781%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DOinFQxAM7lyhwZ3%252BZ%252BByg2BvYU4%253D
         * hospitalServiceType : xlsx
         * hospitalServiceName : 安责险回归测试0815
         */

        private String hospitalServiceUrl;
        private String hospitalServiceType;
        private String hospitalServiceName;

        public String getHospitalServiceUrl() {
            return hospitalServiceUrl;
        }

        public void setHospitalServiceUrl(String hospitalServiceUrl) {
            this.hospitalServiceUrl = hospitalServiceUrl;
        }

        public String getHospitalServiceType() {
            return hospitalServiceType;
        }

        public void setHospitalServiceType(String hospitalServiceType) {
            this.hospitalServiceType = hospitalServiceType;
        }

        public String getHospitalServiceName() {
            return hospitalServiceName;
        }

        public void setHospitalServiceName(String hospitalServiceName) {
            this.hospitalServiceName = hospitalServiceName;
        }
    }
}
