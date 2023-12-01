package com.askia.coremodel.datamodel.http.entities.consume;

public class HttpGetBusyFlag extends CBaseResponseData
{


    /**
     * result : {"flag":false}
     * timestamp : 1632722407967
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
         * flag : false
         */

        private Boolean flag;

        public Boolean isFlag() {
            return flag;
        }

        public void setFlag(Boolean flag) {
            this.flag = flag;
        }
    }
}
