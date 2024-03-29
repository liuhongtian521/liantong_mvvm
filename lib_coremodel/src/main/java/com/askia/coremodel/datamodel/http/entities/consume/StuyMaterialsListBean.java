package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class StuyMaterialsListBean {


    /**
     * records : [{"learningMaterialsType":"pptx","learningMaterialsTag":1,"learningMaterialsUrl":"http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2Fef82226cad644163b2e8c839582f056c.pptx%3FExpires%3D1701929469%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3Di9KlKDg79PB2zP%252Bw4YH5RRw5xTw%253D","learningMaterialsName":"新建 PPTX 演示文稿"}]
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
         * learningMaterialsType : pptx
         * learningMaterialsTag : 1
         * learningMaterialsUrl : http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2Fef82226cad644163b2e8c839582f056c.pptx%3FExpires%3D1701929469%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3Di9KlKDg79PB2zP%252Bw4YH5RRw5xTw%253D
         * learningMaterialsName : 新建 PPTX 演示文稿
         */

        private String learningMaterialsType;
        private int learningMaterialsTag;
        private String learningMaterialsUrl;
        private String learningMaterialsName;

        public String getLearningMaterialsType() {
            return learningMaterialsType;
        }

        public void setLearningMaterialsType(String learningMaterialsType) {
            this.learningMaterialsType = learningMaterialsType;
        }

        public int getLearningMaterialsTag() {
            return learningMaterialsTag;
        }

        public void setLearningMaterialsTag(int learningMaterialsTag) {
            this.learningMaterialsTag = learningMaterialsTag;
        }

        public String getLearningMaterialsUrl() {
            return learningMaterialsUrl;
        }

        public void setLearningMaterialsUrl(String learningMaterialsUrl) {
            this.learningMaterialsUrl = learningMaterialsUrl;
        }

        public String getLearningMaterialsName() {
            return learningMaterialsName;
        }

        public void setLearningMaterialsName(String learningMaterialsName) {
            this.learningMaterialsName = learningMaterialsName;
        }
    }
}
