package com.askia.coremodel.datamodel.http.entities.query;

import java.io.Serializable;
import java.util.List;

/**
 * Create bt she:
 * 广告页面 轮播图
 * @date 2020/10/28
 */
public class AdListData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private int total;
        private int size;
        private int current;
        private boolean searchCount;
        private int pages;
        private List<DataBeanTwo> records;

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

        public boolean getSearchCount() {
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

    public static class DataBeanTwo implements Serializable {
        private String titile;//标题
        private int msgCategory;//分类
        private String msgContent;//内容
        private String createBy;//创建人
        private String createTime;//创建时间
        private String msgImg;//图片
        private String id;//主键ID

        public String getTitile() {
            return titile;
        }

        public void setTitile(String titile) {
            this.titile = titile;
        }

        public int getMsgCategory() {
            return msgCategory;
        }

        public void setMsgCategory(int msgCategory) {
            this.msgCategory = msgCategory;
        }

        public String getMsgContent() {
            return msgContent;
        }

        public void setMsgContent(String msgContent) {
            this.msgContent = msgContent;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getMsgImg() {
            return msgImg;
        }

        public void setMsgImg(String msgImg) {
            this.msgImg = msgImg;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}
