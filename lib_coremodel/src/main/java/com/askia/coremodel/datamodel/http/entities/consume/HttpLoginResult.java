package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

/**
 * Create bt she:
 *
 * @date 2020/12/21
 */
public class HttpLoginResult extends BaseResponseData {

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HttpLoginResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class ResultBean {


        private String token;
        private ResultBeanTwo userInfo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public ResultBeanTwo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(ResultBeanTwo userInfo) {
            this.userInfo = userInfo;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "token='" + token + '\'' +
                    ", userInfo=" + userInfo +
                    '}';
        }
    }

    public static class ResultBeanTwo {
        private String haveChangePwd;
        private String createTime;
        private String realname;

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getHaveChangePwd() {
            return haveChangePwd;
        }

        public void setHaveChangePwd(String haveChangePwd) {
            this.haveChangePwd = haveChangePwd;
        }

        @Override
        public String toString() {
            return "ResultBeanTwo{" +
                    "haveChangePwd='" + haveChangePwd + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", realname='" + realname + '\'' +
                    '}';
        }
    }
}
