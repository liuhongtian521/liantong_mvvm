package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpRankTopBean extends BaseResponseData
{
    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : [{"dishesId":"9","dishesCount":"4","dishesName":"麻辣豆腐","type":""},{"dishesId":"9","dishesCount":"4","dishesName":"麻辣豆腐","type":"1"},{"dishesId":"1","dishesCount":"2","dishesName":"宫保鸡丁盖饭套餐","type":"2"}]
     * timestamp : 1604402330554
     */

    private boolean success;
    private String message;
    private int code;
    private long timestamp;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * dishesId : 9
         * dishesCount : 4
         * dishesName : 麻辣豆腐
         * type :
         */

        private String dishesId;
        private String dishesCount;
        private String dishesName;
        private String type;

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesCount() {
            return dishesCount;
        }

        public void setDishesCount(String dishesCount) {
            this.dishesCount = dishesCount;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
