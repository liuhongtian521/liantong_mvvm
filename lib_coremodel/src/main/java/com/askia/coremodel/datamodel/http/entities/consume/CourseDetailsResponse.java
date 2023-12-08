package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class CourseDetailsResponse {

    /**
     * records : [{"id":"1663054296272465921","tenantId":"","curriculumCode":"","curriculumName":"无主题分享","curriculumType":91,"curriculumTypeDict":"无主题分享","curriculumTopics":"无主题分享","curriculumAddress":"教学楼\nB103","curriculumDate":"2023-06-01","coursewareName":"","coursewareUrl":"","curriculumIntroduction":"","classTime":"19:15-19:25","teacherId":"","teacherName":"","curriculumStatus":"已结束","curriculumId":"1663054296272465921","curriculumNum":0,"classesId":"1654379304946704386"},{"id":"1663054296301826050","tenantId":"","curriculumCode":"","curriculumName":"人工智能、元宇宙的发展及产业应用","curriculumType":2,"curriculumTypeDict":"专题讲座","curriculumTopics":"人工智能、元宇宙的发展及产业应用","curriculumAddress":"教学楼\nB103","curriculumDate":"2023-06-01","coursewareName":"","coursewareUrl":"","curriculumIntroduction":"","classTime":"19:30-22:30","teacherId":"1663018150265593859","teacherName":"范玉顺","curriculumStatus":"已结束","curriculumId":"1663054296301826050","curriculumNum":0,"classesId":"1654379304946704386"},{"id":"1663054296343769089","tenantId":"","curriculumCode":"","curriculumName":"学习回顾及管理案例故事会","curriculumType":6,"curriculumTypeDict":"学员论坛","curriculumTopics":"学习回顾及管理案例故事会","curriculumAddress":"教学楼\nB103","curriculumDate":"2023-06-01","coursewareName":"","coursewareUrl":"","curriculumIntroduction":"","classTime":"01:30-04:30","teacherId":"","teacherName":"","curriculumStatus":"已结束","curriculumId":"1663054296343769089","curriculumNum":0,"classesId":"1654379304946704386"},{"id":"1663054296377323521","tenantId":"","curriculumCode":"","curriculumName":"主题沙龙（选修）","curriculumType":89,"curriculumTypeDict":"主题沙龙（选修）","curriculumTopics":"主题沙龙（选修）","curriculumAddress":"3 号楼\n2 楼\n学习室","curriculumDate":"2023-06-01","coursewareName":"","coursewareUrl":"","curriculumIntroduction":"","classTime":"05:30-07:30","teacherId":"","teacherName":"","curriculumStatus":"已结束","curriculumId":"1663054296377323521","curriculumNum":0,"classesId":"1654379304946704386"}]
     * total : 4
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
         * id : 1663054296272465921
         * tenantId :
         * curriculumCode :
         * curriculumName : 无主题分享
         * curriculumType : 91
         * curriculumTypeDict : 无主题分享
         * curriculumTopics : 无主题分享
         * curriculumAddress : 教学楼
         B103
         * curriculumDate : 2023-06-01
         * coursewareName :
         * coursewareUrl :
         * curriculumIntroduction :
         * classTime : 19:15-19:25
         * teacherId :
         * teacherName :
         * curriculumStatus : 已结束
         * curriculumId : 1663054296272465921
         * curriculumNum : 0
         * classesId : 1654379304946704386
         */

        private String id;
        private String tenantId;
        private String curriculumCode;
        private String curriculumName;
        private int curriculumType;
        private String curriculumTypeDict;
        private String curriculumTopics;
        private String curriculumAddress;
        private String curriculumDate;
        private String coursewareName;
        private String coursewareUrl;
        private String curriculumIntroduction;
        private String classTime;
        private String teacherId;
        private String teacherName;
        private String curriculumStatus;
        private String curriculumId;
        private int curriculumNum;
        private String classesId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getCurriculumCode() {
            return curriculumCode;
        }

        public void setCurriculumCode(String curriculumCode) {
            this.curriculumCode = curriculumCode;
        }

        public String getCurriculumName() {
            return curriculumName;
        }

        public void setCurriculumName(String curriculumName) {
            this.curriculumName = curriculumName;
        }

        public int getCurriculumType() {
            return curriculumType;
        }

        public void setCurriculumType(int curriculumType) {
            this.curriculumType = curriculumType;
        }

        public String getCurriculumTypeDict() {
            return curriculumTypeDict;
        }

        public void setCurriculumTypeDict(String curriculumTypeDict) {
            this.curriculumTypeDict = curriculumTypeDict;
        }

        public String getCurriculumTopics() {
            return curriculumTopics;
        }

        public void setCurriculumTopics(String curriculumTopics) {
            this.curriculumTopics = curriculumTopics;
        }

        public String getCurriculumAddress() {
            return curriculumAddress;
        }

        public void setCurriculumAddress(String curriculumAddress) {
            this.curriculumAddress = curriculumAddress;
        }

        public String getCurriculumDate() {
            return curriculumDate;
        }

        public void setCurriculumDate(String curriculumDate) {
            this.curriculumDate = curriculumDate;
        }

        public String getCoursewareName() {
            return coursewareName;
        }

        public void setCoursewareName(String coursewareName) {
            this.coursewareName = coursewareName;
        }

        public String getCoursewareUrl() {
            return coursewareUrl;
        }

        public void setCoursewareUrl(String coursewareUrl) {
            this.coursewareUrl = coursewareUrl;
        }

        public String getCurriculumIntroduction() {
            return curriculumIntroduction;
        }

        public void setCurriculumIntroduction(String curriculumIntroduction) {
            this.curriculumIntroduction = curriculumIntroduction;
        }

        public String getClassTime() {
            return classTime;
        }

        public void setClassTime(String classTime) {
            this.classTime = classTime;
        }

        public String getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public String getCurriculumStatus() {
            return curriculumStatus;
        }

        public void setCurriculumStatus(String curriculumStatus) {
            this.curriculumStatus = curriculumStatus;
        }

        public String getCurriculumId() {
            return curriculumId;
        }

        public void setCurriculumId(String curriculumId) {
            this.curriculumId = curriculumId;
        }

        public int getCurriculumNum() {
            return curriculumNum;
        }

        public void setCurriculumNum(int curriculumNum) {
            this.curriculumNum = curriculumNum;
        }

        public String getClassesId() {
            return classesId;
        }

        public void setClassesId(String classesId) {
            this.classesId = classesId;
        }
    }
}
