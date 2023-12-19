package com.askia.coremodel.datamodel.http.entities.consume;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

public class HistoryResponse {


    /**
     * total : 4
     * pages : 1
     * pageNum : 1
     * pageSize : 10
     * pageData : [{"id":"1036561358004420608","cmStruId":"833060905079013376","cmContType":30,"contName":"《新闻联播》20221029","imgUri":"","cmFlId":"-1","cmFsId":"-1","link":"","contAbs":"","cont":"","source":"","contLabel":"","contentParentId":"1036561358004420608","contentChildrenId":"","createTime":"2022-10-31 21:45:40","auditStatus":5,"audioListList":[{"id":"1036561358033780736","contId":"1036561358004420608","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/76429831a3e84c5f80b6f962e62063de.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=Oo6jwxISAqF39Fogoknrcjv00PY%3D","contTitle":"《新闻联播》20221029","audioTimeLength":"4.54","contText":"《新闻联播》20221029"}],"contVideo":{"contId":"1036561358004420608","taCmFlId":"1036561348768563200","taCmFsId":"1","timeLength":"29:59","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/bb1d69e58e75428c887bdeebcd9ea2f6.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=MU5gahJnx0HZqf%2BFgnUVcUUwBes%3D"},"remark":"[]"},{"id":"1036931066046185472","cmStruId":"833060905079013376","cmContType":30,"contName":"《新闻联播》20221031","imgUri":"","cmFlId":"-1","cmFsId":"-1","link":"","contAbs":"","cont":"","source":"","contLabel":"","contentParentId":"1036931066046185472","contentChildrenId":"","createTime":"2022-11-01 22:14:00","auditStatus":5,"audioListList":[{"id":"1036931066071351296","contId":"1036931066046185472","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/5431bb7639f14b7c961c80dcf222c689.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=rIukwbJRYGfpdYmsq9ILj7VeyjI%3D","contTitle":"《新闻联播》20221031","audioTimeLength":"4.50","contText":"《新闻联播》20221031"}],"contVideo":{"contId":"1036931066046185472","taCmFlId":"1036931039659819008","taCmFsId":"1","timeLength":"36:00","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/94c494a5ef7741919f44516031646a5c.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=EJ3%2Bf%2F%2BZI4bbIqffLQxArZ%2FnWPM%3D"},"remark":"[]"},{"id":"1036561550900461568","cmStruId":"833060905079013376","cmContType":30,"contName":"《新闻联播》20221030","imgUri":"","cmFlId":"-1","cmFsId":"-1","link":"","contAbs":"","cont":"","source":"","contLabel":"","contentParentId":"1036561550900461568","contentChildrenId":"","createTime":"2022-10-31 21:45:48","auditStatus":5,"audioListList":[{"id":"1036561550934016000","contId":"1036561550900461568","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/af634ba914ea49f08b97aa79048451e5.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=fve8YikLGPe7NBNPbPp6BcNGhQ4%3D","contTitle":"《新闻联播》20221030","audioTimeLength":"4.50","contText":"《新闻联播》20221030"}],"contVideo":{"contId":"1036561550900461568","taCmFlId":"1036561508487659520","taCmFsId":"1","timeLength":"30:01","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/eed858110bc6423fb1931ff764c9517c.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=1nrDwPqdpCGGARYBrzBOlkGOL5M%3D"},"remark":"[]"},{"id":"1035472710945210368","cmStruId":"833060905079013376","cmContType":30,"contName":"《新闻联播》2022102哈","imgUri":"","cmFlId":"-1","cmFsId":"-1","link":"","contAbs":"","cont":"","source":"","contLabel":"","contentParentId":"1035472710945210368","contentChildrenId":"841667742388977664","createTime":"2022-10-28 21:39:01","auditStatus":5,"audioListList":[{"id":"1035472710982959104","contId":"1035472710945210368","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/8831de9ab6a24711a89b6c6cf322172c.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=VxRfhalUZ5Yb9h5oQ4IDSvvEeos%3D","contTitle":"《新闻联播》2022102哈","audioTimeLength":"4.61","contText":"《新闻联播》2022102哈"}],"contVideo":{"contId":"1035472710945210368","taCmFlId":"1035472606888722432","taCmFsId":"1","timeLength":"45:01","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/6401fc23055c4e2e86585b2b20ac41ca.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=r7XqyhiV1ZpSbJmPfGNywffBzjk%3D"},"remark":"[{\"createTime\":\"2021-05-12 23:08:38.0\",\"contName\":\"国际联播快讯\",\"id\":\"841980180334379008\",\"cmStruId\":\"833057630787207168\"},{\"createTime\":\"2021-05-12 02:27:07.0\",\"contName\":\"李克强对2021年中国品牌日活动作出重要批示强调 努力提高产品和服务的质量与综合竞争力 使更多中国品牌成为国内外市场值得信赖的选择\",\"id\":\"841667742388977664\",\"cmStruId\":\"833057630787207168\"}]"}]
     * endRow : 0
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
        if (pageData == null) {
            return new ArrayList<>();
        }
        return pageData;
    }

    public void setPageData(List<PageDataBean> pageData) {
        this.pageData = pageData;
    }

    public static class PageDataBean implements MultiItemEntity {
        /**
         * id : 1036561358004420608
         * cmStruId : 833060905079013376
         * cmContType : 30
         * contName : 《新闻联播》20221029
         * imgUri :
         * cmFlId : -1
         * cmFsId : -1
         * link :
         * contAbs :
         * cont :
         * source :
         * contLabel :
         * contentParentId : 1036561358004420608
         * contentChildrenId :
         * createTime : 2022-10-31 21:45:40
         * auditStatus : 5
         * audioListList : [{"id":"1036561358033780736","contId":"1036561358004420608","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/76429831a3e84c5f80b6f962e62063de.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=Oo6jwxISAqF39Fogoknrcjv00PY%3D","contTitle":"《新闻联播》20221029","audioTimeLength":"4.54","contText":"《新闻联播》20221029"}]
         * contVideo : {"contId":"1036561358004420608","taCmFlId":"1036561348768563200","taCmFsId":"1","timeLength":"29:59","videoUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/bb1d69e58e75428c887bdeebcd9ea2f6.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=MU5gahJnx0HZqf%2BFgnUVcUUwBes%3D"}
         * remark : []
         */
        //item类型
        private int fieldType;

        public void setFieldType(int fieldType) {
            this.fieldType = fieldType;
        }

        @Override
        public int getItemType() {
            return fieldType;
        }

        private String id;
        private String cmStruId;
        private int cmContType;
        private String contName;
        private String imgUri;
        private String cmFlId;
        private String cmFsId;
        private String link;
        private String contAbs;
        private String cont;
        private String source;
        private String contLabel;
        private String contentParentId;
        private String contentChildrenId;
        private String createTime;
        private String imgUrl;
        private int auditStatus;
        private ContVideoBean contVideo;
        private String remark;
        private String bookName;
        private String authorName;
        private String briefIntroduction;
        private String coverUrl;



        public String getBriefIntroduction() {
            return briefIntroduction == null ? "" : briefIntroduction;
        }

        public void setBriefIntroduction(String briefIntroduction) {
            this.briefIntroduction = briefIntroduction;
        }

        public String getAuthorName() {
            return authorName == null ? "" : authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getBookName() {
            return bookName == null ? "" : bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        private List<AudioListListBean> audioListList;

        public String getImgUrl() {
            return imgUrl == null ? "" : imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCmStruId() {
            return cmStruId;
        }

        public void setCmStruId(String cmStruId) {
            this.cmStruId = cmStruId;
        }

        public int getCmContType() {
            return cmContType;
        }

        public void setCmContType(int cmContType) {
            this.cmContType = cmContType;
        }

        public String getContName() {
            return contName == null ? "" : contName;
        }

        public void setContName(String contName) {
            this.contName = contName;
        }

        public String getImgUri() {
            return imgUri == null ? "" : imgUri;
        }

        public void setImgUri(String imgUri) {
            this.imgUri = imgUri;
        }

        public String getCmFlId() {
            return cmFlId;
        }

        public void setCmFlId(String cmFlId) {
            this.cmFlId = cmFlId;
        }

        public String getCmFsId() {
            return cmFsId;
        }

        public void setCmFsId(String cmFsId) {
            this.cmFsId = cmFsId;
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

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getContLabel() {
            return contLabel;
        }

        public void setContLabel(String contLabel) {
            this.contLabel = contLabel;
        }

        public String getContentParentId() {
            return contentParentId;
        }

        public void setContentParentId(String contentParentId) {
            this.contentParentId = contentParentId;
        }

        public String getContentChildrenId() {
            return contentChildrenId;
        }

        public void setContentChildrenId(String contentChildrenId) {
            this.contentChildrenId = contentChildrenId;
        }

        public String getCreateTime() {
            return createTime == null ? "" : createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(int auditStatus) {
            this.auditStatus = auditStatus;
        }

        public ContVideoBean getContVideo() {
            if (contVideo == null)
                contVideo = new ContVideoBean();
            return contVideo;
        }

        public void setContVideo(ContVideoBean contVideo) {
            this.contVideo = contVideo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<AudioListListBean> getAudioListList() {
            return audioListList;
        }

        public void setAudioListList(List<AudioListListBean> audioListList) {
            this.audioListList = audioListList;
        }

        public static class ContVideoBean {
            /**
             * contId : 1036561358004420608
             * taCmFlId : 1036561348768563200
             * taCmFsId : 1
             * timeLength : 29:59
             * videoUrl : http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/bb1d69e58e75428c887bdeebcd9ea2f6.mp4?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=MU5gahJnx0HZqf%2BFgnUVcUUwBes%3D
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
                return timeLength == null ? "" : timeLength;
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
             * id : 1036561358033780736
             * contId : 1036561358004420608
             * sort : 1
             * audioUrl : http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/76429831a3e84c5f80b6f962e62063de.mp3?Expires=1702967448&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=Oo6jwxISAqF39Fogoknrcjv00PY%3D
             * contTitle : 《新闻联播》20221029
             * audioTimeLength : 4.54
             * contText : 《新闻联播》20221029
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
