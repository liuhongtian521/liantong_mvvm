package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class StuyManualListBean {


    /**
     * records : [{"classesName":"中央企业领导人员治企能力提升专题培训班（第6期）","classStudentHandbookUrl":"http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F1f310d7dfa8a4bcdb166442938451381.pdf%3FExpires%3D1701931450%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DiAxJMo71oApmdkdSv8bLbbGrOt0%253D"}]
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
         * classesName : 中央企业领导人员治企能力提升专题培训班（第6期）
         * classStudentHandbookUrl : http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F1f310d7dfa8a4bcdb166442938451381.pdf%3FExpires%3D1701931450%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DiAxJMo71oApmdkdSv8bLbbGrOt0%253D
         */

        private String classesName;
        private String classStudentHandbookUrl;

        public String getClassesName() {
            return classesName;
        }

        public void setClassesName(String classesName) {
            this.classesName = classesName;
        }

        public String getClassStudentHandbookUrl() {
            return classStudentHandbookUrl;
        }

        public void setClassStudentHandbookUrl(String classStudentHandbookUrl) {
            this.classStudentHandbookUrl = classStudentHandbookUrl;
        }
    }
}
