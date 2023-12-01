package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

/**
 * 统计页面订单数量和金额查询的返回
 */
public class HttpSaleStatusBean extends CBaseResponseData {

    /**
     * result : {"total":34,"record":[{"mealDate":"2020/11","sumMoney":"1515.00","amount":"34"}],"totalMoney":1515}
     * timestamp : 1604382576896
     */

    private List<RecordBean> result;
    private long timestamp;


    public List<RecordBean> getResult() {
        return result;
    }

    public void setResult(List<RecordBean> result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class RecordBean {

        private String columnChartTime;
        private String money;
        private String num;

        public String getColumnChartTime() {
            return columnChartTime;
        }

        public void setColumnChartTime(String columnChartTime) {
            this.columnChartTime = columnChartTime;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }
}
