package com.askia.coremodel.datamodel.http.entities.consume;

public class HttpCheckTokenBean extends CBaseResponseData
{


    /**
     * result : {"flag":true,"token":""}
     * timestamp : 1632721675552
     */

    private ResultBean result;
    private Long timestamp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        /**
         * flag : true
         * token :
         */

        private Boolean flag;
        private String token;

        public Boolean isFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
