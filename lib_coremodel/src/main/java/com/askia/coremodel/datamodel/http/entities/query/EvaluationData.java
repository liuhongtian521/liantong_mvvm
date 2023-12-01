package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 * 评价
 * @date 2020/10/27
 */
public class EvaluationData extends QBaseResponseData {

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
        private int pages;

        public List<DataBeanTwo> getRecords() {
            return records;
        }

        public void setRecords(List<DataBeanTwo> records) {
            this.records = records;
        }

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

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    public static class DataBeanTwo {
        private String makeTime;
        private String ownerName;
        private String commentId;
        private String remark;
        private String commentLeavel;
        private List<String> imgList;
        private String dishesImg;
        private String dishesName;
        private String studentImg;
        public String getStudentImg() {
            return studentImg;
        }

        public void setStudentImg(String studentImg) {
            this.studentImg = studentImg;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getDishesImg() {
            return dishesImg;
        }

        public void setDishesImg(String dishesImg) {
            this.dishesImg = dishesImg;
        }

        public String getMakeTime() {
            return makeTime;
        }

        public void setMakeTime(String makeTime) {
            this.makeTime = makeTime;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCommentLeavel() {
            return commentLeavel;
        }

        public void setCommentLeavel(String commentLeavel) {
            this.commentLeavel = commentLeavel;
        }

        public List<String> getImgList() {
            return imgList;
        }

        public void setImgList(List<String> imgList) {
            this.imgList = imgList;
        }
    }
}

