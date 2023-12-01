package com.askia.coremodel.datamodel.http.entities.query;

import java.util.List;

/**
 * Create bt she:
 *
 * @date 2020/11/4
 */
public class DisheAboutData extends QBaseResponseData {

    private List<DataBean> result;

    public List<DataBean> getResult() {
        return result;
    }

    public void setResult(List<DataBean> result) {
        this.result = result;
    }

    public static class DataBean {
        private String dishesId;
        private String dishesName;
        private String dishesImg;
        private String dishesMoney;

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getDishesImg() {
            return dishesImg;
        }

        public void setDishesImg(String dishesImg) {
            this.dishesImg = dishesImg;
        }
    }

}
