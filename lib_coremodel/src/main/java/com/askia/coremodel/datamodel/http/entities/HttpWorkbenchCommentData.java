package com.askia.coremodel.datamodel.http.entities;

/**
 * Create bt she:
 *
 * @date 2020/12/15
 */
public class HttpWorkbenchCommentData extends BaseResponseData {
    private boolean success;
    private String message;
    private int code;
    private ResultBean result;
    private long timestamp;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {

        private String allComment;
        private String goodDishesName;
        private String goodDishesComment;
        private String lowDishesName;
        private String lowDishesComment;

        public String getAllComment() {
            return allComment;
        }

        public void setAllComment(String allComment) {
            this.allComment = allComment;
        }

        public String getGoodDishesName() {
            return goodDishesName;
        }

        public void setGoodDishesName(String goodDishesName) {
            this.goodDishesName = goodDishesName;
        }

        public String getGoodDishesComment() {
            return goodDishesComment;
        }

        public void setGoodDishesComment(String goodDishesComment) {
            this.goodDishesComment = goodDishesComment;
        }

        public String getLowDishesName() {
            return lowDishesName;
        }

        public void setLowDishesName(String lowDishesName) {
            this.lowDishesName = lowDishesName;
        }

        public String getLowDishesComment() {
            return lowDishesComment;
        }

        public void setLowDishesComment(String lowDishesComment) {
            this.lowDishesComment = lowDishesComment;
        }
    }
}
