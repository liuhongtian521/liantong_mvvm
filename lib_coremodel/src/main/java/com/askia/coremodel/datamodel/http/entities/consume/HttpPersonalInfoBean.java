package com.askia.coremodel.datamodel.http.entities.consume;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HttpPersonalInfoBean extends CBaseResponseData
{
    /**
     * result : {"cardNo":"","className":"","code":"","name":"","orgCode":""}
     * timestamp : 0
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean{
        private String flag;
        private String timeStamp;
        private List<listInfo> listInfo;

        public List<listInfo> getListInfo() {
            return listInfo;
        }

        public void setListInfo(List<listInfo> result) {
            this.listInfo = result;
        }
    }
    public static class listInfo {
        /**
         * cardNo :
         * className :
         * code :
         * name :
         * orgCode :
         */

        private String cardNo;
        private String className;
        private String code;
        private String name;
        private String orgCode;
        // 卡状态 0 正常  1 异常
        private String cardStatus;
        // 账户状态 0 正常  1 禁止消费
        private String accountStatus;

        public String getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getCardStatus() {
            return cardStatus;
        }

        public void setCardStatus(String cardStatus) {
            this.cardStatus = cardStatus;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }
    }
}
