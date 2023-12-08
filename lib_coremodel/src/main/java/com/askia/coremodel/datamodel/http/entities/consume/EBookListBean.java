package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class EBookListBean {


    /**
     * records : [{"id":"1438069341011623938","createUser":"1410414946339442689","createDept":"1300262833002422274","createTime":"2021-09-16 06:17:04","updateUser":"1410414946339442689","updateTime":"2021-09-16 06:17:04","status":1,"isDeleted":0,"tenantId":"000000","coursewareCode":"","coursewareName":"颜晓峰-习近平新时代中国特色社会主义思想","coursewareType":"pdf","coursewareUrl":"http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F4ad55ce8c4a64c9da9a6fb154596fc6f.pdf%3FExpires%3D1701852326%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DmNhMzLZFdqCVOCwJgyPOfE6CwuU%253D","curriculumId":"","classesId":""}]
     * total : 43
     * size : 1
     * current : 10
     * orders : []
     * optimizeCountSql : true
     * hitCount : false
     * searchCount : true
     * pages : 43
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
         * id : 1438069341011623938
         * createUser : 1410414946339442689
         * createDept : 1300262833002422274
         * createTime : 2021-09-16 06:17:04
         * updateUser : 1410414946339442689
         * updateTime : 2021-09-16 06:17:04
         * status : 1
         * isDeleted : 0
         * tenantId : 000000
         * coursewareCode :
         * coursewareName : 颜晓峰-习近平新时代中国特色社会主义思想
         * coursewareType : pdf
         * coursewareUrl : http%3A%2F%2Fcldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com%2F4ad55ce8c4a64c9da9a6fb154596fc6f.pdf%3FExpires%3D1701852326%26OSSAccessKeyId%3DLTAI5tE8k22tASfQeMbdKwo6%26Signature%3DmNhMzLZFdqCVOCwJgyPOfE6CwuU%253D
         * curriculumId :
         * classesId :
         */

        private String id;
        private String createUser;
        private String createDept;
        private String createTime;
        private String updateUser;
        private String updateTime;
        private int status;
        private int isDeleted;
        private String tenantId;
        private String coursewareCode;
        private String coursewareName;
        private String coursewareType;
        private String coursewareUrl;
        private String curriculumId;
        private String classesId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCreateDept() {
            return createDept;
        }

        public void setCreateDept(String createDept) {
            this.createDept = createDept;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(String updateUser) {
            this.updateUser = updateUser;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(int isDeleted) {
            this.isDeleted = isDeleted;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getCoursewareCode() {
            return coursewareCode;
        }

        public void setCoursewareCode(String coursewareCode) {
            this.coursewareCode = coursewareCode;
        }

        public String getCoursewareName() {
            return coursewareName;
        }

        public void setCoursewareName(String coursewareName) {
            this.coursewareName = coursewareName;
        }

        public String getCoursewareType() {
            return coursewareType;
        }

        public void setCoursewareType(String coursewareType) {
            this.coursewareType = coursewareType;
        }

        public String getCoursewareUrl() {
            return coursewareUrl;
        }

        public void setCoursewareUrl(String coursewareUrl) {
            this.coursewareUrl = coursewareUrl;
        }

        public String getCurriculumId() {
            return curriculumId;
        }

        public void setCurriculumId(String curriculumId) {
            this.curriculumId = curriculumId;
        }

        public String getClassesId() {
            return classesId;
        }

        public void setClassesId(String classesId) {
            this.classesId = classesId;
        }
    }
}
