package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class HttpSyncShoppingBean extends CBaseResponseData{

    /**
     * result : {"sn":"","sunccessList":[{"id":"","status":0}]}
     * timestamp : 0
     */

    private ResultBean result;
    private String timestamp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        /**
         * sn :
         * sunccessList : [{"id":"","status":0}]
         */

        private String sn;
        private List<SunccessListBean> sunccessList;

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public List<SunccessListBean> getSunccessList() {
            return sunccessList;
        }

        public void setSunccessList(List<SunccessListBean> sunccessList) {
            this.sunccessList = sunccessList;
        }

        public static class SunccessListBean {
            /**
             * id :
             * status : 0
             */

            private String id;
            private Integer status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }
        }
    }

}
