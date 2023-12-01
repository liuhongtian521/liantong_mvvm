package com.askia.coremodel.datamodel.http.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Create bt she:
 *
 * @date 2019/11/18
 */
public class GetCPListResponseData extends BaseResponseData {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * "mealName": "龙井虾仁",
         * "mealDate": "2019-11-04",
         * "mealTime": "11:30-12:30",
         * "mealConstitute":""
         * "mealImg":"http://218.60.2.191:80/appdownload/mealPhoto/1571709762340.jpeg"
         */

        private String mealName;
        private String mealDate;
        private String mealTime;
        private String mealImg;
        private  String mealConstitute;

        public String getMealConstitute() {
            return mealConstitute;
        }

        public void setMealConstitute(String mealConstitute) {
            this.mealConstitute = mealConstitute;
        }

        public String getMealName() {
            return mealName;
        }

        public void setMealName(String mealName) {
            this.mealName = mealName;
        }

        public String getMealDate() {
            return mealDate;
        }

        public void setMealDate(String mealDate) {
            this.mealDate = mealDate;
        }

        public String getMealTime() {
            return mealTime;
        }

        public void setMealTime(String mealTime) {
            this.mealTime = mealTime;
        }

        public String getMealImg() {
            return mealImg;
        }

        public void setMealImg(String mealImg) {
            this.mealImg = mealImg;
        }
    }

}
