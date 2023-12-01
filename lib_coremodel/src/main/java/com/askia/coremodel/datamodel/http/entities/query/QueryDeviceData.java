package com.askia.coremodel.datamodel.http.entities.query;

/**
 * Create bt she:
 *
 * @date 2020/12/11
 */
public class QueryDeviceData extends QBaseResponseData {

    private DataBean result;


    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private String password;
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
}
