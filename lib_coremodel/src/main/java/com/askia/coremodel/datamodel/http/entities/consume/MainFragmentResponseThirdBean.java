package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class MainFragmentResponseThirdBean {

    /**
     * total : 535
     * pages : 179
     * pageNum : 1
     * pageSize : 3
     * pageData : [{"id":"1036931066046185472","contName":"《新闻联播》20221031","isDisplay":1,"displayInx":1,"createTime":"2022-11-01 22:14:00","viewCount":32,"praiseCount":0,"commCount":0,"isAttr":0,"isTiming":-1,"remark":"","collection":"","source":"","isTop":0,"isHot":1,"audioListList":[{"id":"1036931066071351296","contId":"1036931066046185472","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/5431bb7639f14b7c961c80dcf222c689.mp3?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=KMrO44ijy%2FMMtRBM3Y4FspBNKyY%3D","contTitle":"《新闻联播》20221031","audioTimeLength":"4.50","contText":""}],"contVideo":{"contId":"","taCmFlId":"","taCmFsId":"","timeLength":"36:00","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/94c494a5ef7741919f44516031646a5c.mp4?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=CTGRBjBwukZ5EeTNcoXz97qaHGw%3D"},"imgUrl":"","link":"","contAbs":"","contDesc":"","contDesc2":"","contDesc3":""},{"id":"1036561550900461568","contName":"《新闻联播》20221030","isDisplay":1,"displayInx":1,"createTime":"2022-10-31 21:45:48","viewCount":5,"praiseCount":0,"commCount":0,"isAttr":0,"isTiming":-1,"remark":"","collection":"","source":"","isTop":0,"isHot":1,"audioListList":[{"id":"1036561550934016000","contId":"1036561550900461568","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/af634ba914ea49f08b97aa79048451e5.mp3?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=PpQJCE3Xm8aAacRV9z9nyaUSjcE%3D","contTitle":"《新闻联播》20221030","audioTimeLength":"4.50","contText":""}],"contVideo":{"contId":"","taCmFlId":"","taCmFsId":"","timeLength":"30:01","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/eed858110bc6423fb1931ff764c9517c.mp4?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=TWEcDEx7hhHdARZNBOtO%2BazEvFU%3D"},"imgUrl":"","link":"","contAbs":"","contDesc":"","contDesc2":"","contDesc3":""},{"id":"1036561358004420608","contName":"《新闻联播》20221029","isDisplay":1,"displayInx":1,"createTime":"2022-10-31 21:45:40","viewCount":5,"praiseCount":0,"commCount":0,"isAttr":0,"isTiming":-1,"remark":"","collection":"","source":"","isTop":0,"isHot":1,"audioListList":[{"id":"1036561358033780736","contId":"1036561358004420608","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/76429831a3e84c5f80b6f962e62063de.mp3?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=OtempFJkWOUlyqOvZXneDRNzECM%3D","contTitle":"《新闻联播》20221029","audioTimeLength":"4.54","contText":""}],"contVideo":{"contId":"","taCmFlId":"","taCmFsId":"","timeLength":"29:59","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/bb1d69e58e75428c887bdeebcd9ea2f6.mp4?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=XT2P%2FzYdbdR2ILW2Mas21KPQ%2Fc4%3D"},"imgUrl":"","link":"","contAbs":"","contDesc":"","contDesc2":"","contDesc3":""}]
     * endRow : 3
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
         * id : 1036931066046185472
         * contName : 《新闻联播》20221031
         * isDisplay : 1
         * displayInx : 1
         * createTime : 2022-11-01 22:14:00
         * viewCount : 32
         * praiseCount : 0
         * commCount : 0
         * isAttr : 0
         * isTiming : -1
         * remark :
         * collection :
         * source :
         * isTop : 0
         * isHot : 1
         * audioListList : [{"id":"1036931066071351296","contId":"1036931066046185472","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/5431bb7639f14b7c961c80dcf222c689.mp3?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=KMrO44ijy%2FMMtRBM3Y4FspBNKyY%3D","contTitle":"《新闻联播》20221031","audioTimeLength":"4.50","contText":""}]
         * contVideo : {"contId":"","taCmFlId":"","taCmFsId":"","timeLength":"36:00","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/94c494a5ef7741919f44516031646a5c.mp4?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=CTGRBjBwukZ5EeTNcoXz97qaHGw%3D"}
         * imgUrl :
         * link :
         * contAbs :
         * contDesc :
         * contDesc2 :
         * contDesc3 :
         */

        private String id;
        private String contName;
        private int isDisplay;
        private int displayInx;
        private String createTime;
        private int viewCount;
        private int praiseCount;
        private int commCount;
        private int isAttr;
        private int isTiming;
        private String remark;
        private String collection;
        private String source;
        private int isTop;
        private int isHot;
        private ContVideoBean contVideo;
        private String imgUrl;
        private String link;
        private String contAbs;
        private String contDesc;
        private String contDesc2;
        private String contDesc3;
        private List<AudioListListBean> audioListList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContName() {
            return contName;
        }

        public void setContName(String contName) {
            this.contName = contName;
        }

        public int getIsDisplay() {
            return isDisplay;
        }

        public void setIsDisplay(int isDisplay) {
            this.isDisplay = isDisplay;
        }

        public int getDisplayInx() {
            return displayInx;
        }

        public void setDisplayInx(int displayInx) {
            this.displayInx = displayInx;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public int getPraiseCount() {
            return praiseCount;
        }

        public void setPraiseCount(int praiseCount) {
            this.praiseCount = praiseCount;
        }

        public int getCommCount() {
            return commCount;
        }

        public void setCommCount(int commCount) {
            this.commCount = commCount;
        }

        public int getIsAttr() {
            return isAttr;
        }

        public void setIsAttr(int isAttr) {
            this.isAttr = isAttr;
        }

        public int getIsTiming() {
            return isTiming;
        }

        public void setIsTiming(int isTiming) {
            this.isTiming = isTiming;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public ContVideoBean getContVideo() {
            return contVideo;
        }

        public void setContVideo(ContVideoBean contVideo) {
            this.contVideo = contVideo;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getContAbs() {
            return contAbs;
        }

        public void setContAbs(String contAbs) {
            this.contAbs = contAbs;
        }

        public String getContDesc() {
            return contDesc;
        }

        public void setContDesc(String contDesc) {
            this.contDesc = contDesc;
        }

        public String getContDesc2() {
            return contDesc2;
        }

        public void setContDesc2(String contDesc2) {
            this.contDesc2 = contDesc2;
        }

        public String getContDesc3() {
            return contDesc3;
        }

        public void setContDesc3(String contDesc3) {
            this.contDesc3 = contDesc3;
        }

        public List<AudioListListBean> getAudioListList() {
            return audioListList;
        }

        public void setAudioListList(List<AudioListListBean> audioListList) {
            this.audioListList = audioListList;
        }

        public static class ContVideoBean {
            /**
             * contId :
             * taCmFlId :
             * taCmFsId :
             * timeLength : 36:00
             * videoUrl : http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/94c494a5ef7741919f44516031646a5c.mp4?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=CTGRBjBwukZ5EeTNcoXz97qaHGw%3D
             */

            private String contId;
            private String taCmFlId;
            private String taCmFsId;
            private String timeLength;
            private String videoUrl;

            public String getContId() {
                return contId;
            }

            public void setContId(String contId) {
                this.contId = contId;
            }

            public String getTaCmFlId() {
                return taCmFlId;
            }

            public void setTaCmFlId(String taCmFlId) {
                this.taCmFlId = taCmFlId;
            }

            public String getTaCmFsId() {
                return taCmFsId;
            }

            public void setTaCmFsId(String taCmFsId) {
                this.taCmFsId = taCmFsId;
            }

            public String getTimeLength() {
                return timeLength;
            }

            public void setTimeLength(String timeLength) {
                this.timeLength = timeLength;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }

        public static class AudioListListBean {
            /**
             * id : 1036931066071351296
             * contId : 1036931066046185472
             * sort : 1
             * audioUrl : http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/5431bb7639f14b7c961c80dcf222c689.mp3?Expires=1702282148&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=KMrO44ijy%2FMMtRBM3Y4FspBNKyY%3D
             * contTitle : 《新闻联播》20221031
             * audioTimeLength : 4.50
             * contText :
             */

            private String id;
            private String contId;
            private int sort;
            private String audioUrl;
            private String contTitle;
            private String audioTimeLength;
            private String contText;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContId() {
                return contId;
            }

            public void setContId(String contId) {
                this.contId = contId;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getAudioUrl() {
                return audioUrl;
            }

            public void setAudioUrl(String audioUrl) {
                this.audioUrl = audioUrl;
            }

            public String getContTitle() {
                return contTitle;
            }

            public void setContTitle(String contTitle) {
                this.contTitle = contTitle;
            }

            public String getAudioTimeLength() {
                return audioTimeLength;
            }

            public void setAudioTimeLength(String audioTimeLength) {
                this.audioTimeLength = audioTimeLength;
            }

            public String getContText() {
                return contText;
            }

            public void setContText(String contText) {
                this.contText = contText;
            }
        }
    }
}
