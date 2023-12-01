package com.askia.coremodel.datamodel.http.entities;

public class TimeLisData extends BaseResponseData {
    private DataBean[] data;

    public DataBean[] getData() {
        return data;
    }

    public void setData(DataBean[] data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * {"endTime":"12:30",
         * "sort":2,
         * "startTime":"11:20",
         * "delFlag":"0",
         * "createDate":"2020-03-01 11:05:41",
         * "updateDate":"2020-09-22 11:32:28",
         * "id":"2","type":"中午用餐时间"
         */
        private String endTime;
        private String startTime;

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }
}
