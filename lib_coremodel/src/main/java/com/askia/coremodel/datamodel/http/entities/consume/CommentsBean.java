package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class CommentsBean {


    /**
     * total : 2
     * pages : 1
     * pageNum : 1
     * pageSize : 100
     * pageData : [{"id":"1183804914808127488","cmContId":"879682588225044480","userId":"1673870114430152705","commUserHand":"","commUserNick":"鱼鱼","commTime":"2023-12-11 16:18:06","commTheme":"","commContent":"ddddd","replyPid":"-1","replyUserId":"","replyUserHand":"","replyUserNick":"","replyTime":"","replyTheme":"","replyContent":"","commStatus":0,"remark":"","createBy":"1673870114430152705","createTime":"2023-12-11 16:18:06","updateBy":"","updateTime":"","status":1,"createName":"鱼鱼","updateName":""},{"id":"1183804953244729344","cmContId":"879682588225044480","userId":"1673870114430152705","commUserHand":"","commUserNick":"鱼鱼","commTime":"2023-12-11 16:18:15","commTheme":"","commContent":"bbjjjjjjj","replyPid":"-1","replyUserId":"","replyUserHand":"","replyUserNick":"","replyTime":"","replyTheme":"","replyContent":"","commStatus":0,"remark":"","createBy":"1673870114430152705","createTime":"2023-12-11 16:18:15","updateBy":"","updateTime":"","status":1,"createName":"鱼鱼","updateName":""}]
     * endRow : 100
     * startRow : 0
     */

    private int total;
    private int pages;
    private int pageNum;
    private int pageSize;
    private int endRow;
    private int startRow;
    private List<PageDataBean> pageData;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public List<PageDataBean> getPageData() {
        return pageData;
    }

    public void setPageData(List<PageDataBean> pageData) {
        this.pageData = pageData;
    }

    public static class PageDataBean {
        /**
         * id : 1183804914808127488
         * cmContId : 879682588225044480
         * userId : 1673870114430152705
         * commUserHand :
         * commUserNick : 鱼鱼
         * commTime : 2023-12-11 16:18:06
         * commTheme :
         * commContent : ddddd
         * replyPid : -1
         * replyUserId :
         * replyUserHand :
         * replyUserNick :
         * replyTime :
         * replyTheme :
         * replyContent :
         * commStatus : 0
         * remark :
         * createBy : 1673870114430152705
         * createTime : 2023-12-11 16:18:06
         * updateBy :
         * updateTime :
         * status : 1
         * createName : 鱼鱼
         * updateName :
         */

        private String id;
        private String cmContId;
        private String userId;
        private String commUserHand;
        private String commUserNick;
        private String commTime;
        private String commTheme;
        private String commContent;
        private String replyPid;
        private String replyUserId;
        private String replyUserHand;
        private String replyUserNick;
        private String replyTime;
        private String replyTheme;
        private String replyContent;
        private int commStatus;
        private String remark;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private int status;
        private String createName;
        private String updateName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCmContId() {
            return cmContId;
        }

        public void setCmContId(String cmContId) {
            this.cmContId = cmContId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCommUserHand() {
            return commUserHand;
        }

        public void setCommUserHand(String commUserHand) {
            this.commUserHand = commUserHand;
        }

        public String getCommUserNick() {
            return commUserNick;
        }

        public void setCommUserNick(String commUserNick) {
            this.commUserNick = commUserNick;
        }

        public String getCommTime() {
            return commTime;
        }

        public void setCommTime(String commTime) {
            this.commTime = commTime;
        }

        public String getCommTheme() {
            return commTheme;
        }

        public void setCommTheme(String commTheme) {
            this.commTheme = commTheme;
        }

        public String getCommContent() {
            return commContent;
        }

        public void setCommContent(String commContent) {
            this.commContent = commContent;
        }

        public String getReplyPid() {
            return replyPid;
        }

        public void setReplyPid(String replyPid) {
            this.replyPid = replyPid;
        }

        public String getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(String replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyUserHand() {
            return replyUserHand;
        }

        public void setReplyUserHand(String replyUserHand) {
            this.replyUserHand = replyUserHand;
        }

        public String getReplyUserNick() {
            return replyUserNick;
        }

        public void setReplyUserNick(String replyUserNick) {
            this.replyUserNick = replyUserNick;
        }

        public String getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(String replyTime) {
            this.replyTime = replyTime;
        }

        public String getReplyTheme() {
            return replyTheme;
        }

        public void setReplyTheme(String replyTheme) {
            this.replyTheme = replyTheme;
        }

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public int getCommStatus() {
            return commStatus;
        }

        public void setCommStatus(int commStatus) {
            this.commStatus = commStatus;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
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

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }
    }
}
