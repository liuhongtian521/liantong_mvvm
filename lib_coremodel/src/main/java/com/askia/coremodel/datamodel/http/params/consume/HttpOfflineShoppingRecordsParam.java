package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

import java.util.List;

public class HttpOfflineShoppingRecordsParam extends BaseRequestParams {

    /**
     * detailList : [{"cardNo":"","code":"","createTime":"","deviceCode":"","id":"","money":"","orderStatus":0,"transTime":""}]
     * sn :
     * totalList : [{"date":"","total":0}]
     */

    private String sn;
    private List<DetailListBean> detailList;
    private List<TotalListBean> totalList;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<DetailListBean> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<DetailListBean> detailList) {
        this.detailList = detailList;
    }

    public List<TotalListBean> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<TotalListBean> totalList) {
        this.totalList = totalList;
    }

    public static class DetailListBean {
        /**
         * cardNo :
         * code :
         * createTime :
         * deviceCode :
         * id :
         * money :
         * orderStatus : 0
         * transTime :
         */

        private String cardNo;
        private String code;
        private String createTime;
        private String deviceCode;
        private String id;
        private String money;
        private String orderStatus;
        private String name;
        private String transTime;
        private String refundTime;


        public String getRefundUser() {
            return refundUser;
        }

        public void setRefundUser(String refundUser) {
            this.refundUser = refundUser;
        }
        public String getOrderUser() {
            return orderUser;
        }

        public void setOrderUser(String orderUser) {
            this.orderUser = orderUser;
        }

        //操作员信息
        private String orderUser;
        //退单人信息
        private String refundUser;

        public String getRefundTime() {
            return refundTime;
        }

        public void setRefundTime(String refundTime) {
            this.refundTime = refundTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeviceCode() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode = deviceCode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getTransTime() {
            return transTime;
        }

        public void setTransTime(String transTime) {
            this.transTime = transTime;
        }
    }

    public static class TotalListBean {
        /**
         * date :
         * total : 0
         */

        private String date;
        private Integer total;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }
    }
}
