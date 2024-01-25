package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class DiscussRoomDetailsResponse {

    /**
     * total : 1
     * pages : 1
     * pageNum : 1
     * pageSize : 10
     * pageData : [{"id":"842796468870840320","cmTenantId":"","roomId":"842773540980654080","publishingEnd":"PC","topicTitle":"自身企业培育世界一流企业的难点和制约因素","topicContent":"欢迎大家基于自身的企业管理背景，深入探讨培育世界一流企业的难点和制约因素","topicImg":"http://cdlscms.oss-cn-huhehaote-nebula-1.aliyuncs.com/05d24de2437041878c2328d46f884e0b.png?Expires=1706149491&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=AGLmenG%2FuU%2FzEW1ClH6st6jUxfI%3D","topicVideo":"","createBy":"1384742462555287554","createTime":"2021-05-14 16:12:17","updateBy":"","updateTime":"","publishTime":"2021-05-14 16:12:17","createName":"运营者","updateName":"","createUserImg":"","status":1,"followCount":"1","roomName":"培育世界一流企业","createTimeStr":"","roomStatus":"","isFollow":"","roomCreateBy":"","roomAdminUserId":""}]
     * endRow : 10
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
         * id : 842796468870840320
         * cmTenantId :
         * roomId : 842773540980654080
         * publishingEnd : PC
         * topicTitle : 自身企业培育世界一流企业的难点和制约因素
         * topicContent : 欢迎大家基于自身的企业管理背景，深入探讨培育世界一流企业的难点和制约因素
         * topicImg : http://cdlscms.oss-cn-huhehaote-nebula-1.aliyuncs.com/05d24de2437041878c2328d46f884e0b.png?Expires=1706149491&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=AGLmenG%2FuU%2FzEW1ClH6st6jUxfI%3D
         * topicVideo :
         * createBy : 1384742462555287554
         * createTime : 2021-05-14 16:12:17
         * updateBy :
         * updateTime :
         * publishTime : 2021-05-14 16:12:17
         * createName : 运营者
         * updateName :
         * createUserImg :
         * status : 1
         * followCount : 1
         * roomName : 培育世界一流企业
         * createTimeStr :
         * roomStatus :
         * isFollow :
         * roomCreateBy :
         * roomAdminUserId :
         */

        private String id;
        private String cmTenantId;
        private String roomId;
        private String publishingEnd;
        private String topicTitle;
        private String topicContent;
        private String topicImg;
        private String topicVideo;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String publishTime;
        private String createName;
        private String updateName;
        private String createUserImg;
        private int status;
        private String followCount;
        private String roomName;
        private String createTimeStr;
        private String roomStatus;
        private String isFollow;
        private String roomCreateBy;
        private String roomAdminUserId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCmTenantId() {
            return cmTenantId;
        }

        public void setCmTenantId(String cmTenantId) {
            this.cmTenantId = cmTenantId;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getPublishingEnd() {
            return publishingEnd;
        }

        public void setPublishingEnd(String publishingEnd) {
            this.publishingEnd = publishingEnd;
        }

        public String getTopicTitle() {
            return topicTitle;
        }

        public void setTopicTitle(String topicTitle) {
            this.topicTitle = topicTitle;
        }

        public String getTopicContent() {
            return topicContent;
        }

        public void setTopicContent(String topicContent) {
            this.topicContent = topicContent;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicVideo() {
            return topicVideo;
        }

        public void setTopicVideo(String topicVideo) {
            this.topicVideo = topicVideo;
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

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
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

        public String getCreateUserImg() {
            return createUserImg;
        }

        public void setCreateUserImg(String createUserImg) {
            this.createUserImg = createUserImg;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFollowCount() {
            return followCount;
        }

        public void setFollowCount(String followCount) {
            this.followCount = followCount;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }

        public String getIsFollow() {
            return isFollow;
        }

        public void setIsFollow(String isFollow) {
            this.isFollow = isFollow;
        }

        public String getRoomCreateBy() {
            return roomCreateBy;
        }

        public void setRoomCreateBy(String roomCreateBy) {
            this.roomCreateBy = roomCreateBy;
        }

        public String getRoomAdminUserId() {
            return roomAdminUserId;
        }

        public void setRoomAdminUserId(String roomAdminUserId) {
            this.roomAdminUserId = roomAdminUserId;
        }
    }
}
