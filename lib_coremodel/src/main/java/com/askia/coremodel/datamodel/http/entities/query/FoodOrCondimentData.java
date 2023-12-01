package com.askia.coremodel.datamodel.http.entities.query;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

/**
 * Create bt she:
 *
 * @date 2020/12/1
 */
public class FoodOrCondimentData extends QBaseResponseData {
    private List<DataBean> result;

    public List<DataBean> getResult() {
        return result;
    }

    public void setResult(List<DataBean> result) {
        this.result = result;
    }

    public static class DataBean {

        private String foodId;
        private String foodName;
        private String foodType;
        private String content;

        public String getFoodId() {
            return foodId;
        }

        public void setFoodId(String foodId) {
            this.foodId = foodId;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getFoodType() {
            return foodType;
        }

        public void setFoodType(String foodType) {
            this.foodType = foodType;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
