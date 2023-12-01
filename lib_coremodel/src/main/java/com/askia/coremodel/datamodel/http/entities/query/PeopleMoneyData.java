package com.askia.coremodel.datamodel.http.entities.query;

/**
 * Create bt she:
 * 广告页面 轮播图
 *
 * @date 2020/10/28
 */
public class PeopleMoneyData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private String personName;

        private String money;

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }


}
