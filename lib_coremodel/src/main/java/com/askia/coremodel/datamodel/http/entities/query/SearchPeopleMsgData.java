package com.askia.coremodel.datamodel.http.entities.query;

/**
 * Create bt she:
 * 返回个人信息
 *
 * @date 2020/10/28
 */
public class SearchPeopleMsgData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private String ownerName;
        private String ownerClass;
        private String ownerCode;
        private String ownerMoney;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerClass() {
            return ownerClass;
        }

        public void setOwnerClass(String ownerClass) {
            this.ownerClass = ownerClass;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public String getOwnerMoney() {
            return ownerMoney;
        }

        public void setOwnerMoney(String ownerMoney) {
            this.ownerMoney = ownerMoney;
        }
    }
}
