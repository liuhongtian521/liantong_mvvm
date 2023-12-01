package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class HotSearchData extends BaseResponseData
{
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * meal_name : A套餐
         */

        private String meal_name;

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }
    }
}
