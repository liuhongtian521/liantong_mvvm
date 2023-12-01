package com.askia.coremodel.datamodel.http.entities.query;

/**
 * Create bt she:
 *
 * @date 2020/12/1
 */
public class DishesNutritionRemarkData extends QBaseResponseData {

    private DataBean result;

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }

    public static class DataBean {
        private String disheName;
        private String remark;
        private String nutritionId;
        private String nutritionName;
        private String content;

        public String getDisheName() {
            return disheName;
        }

        public void setDisheName(String disheName) {
            this.disheName = disheName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getNutritionId() {
            return nutritionId;
        }

        public void setNutritionId(String nutritionId) {
            this.nutritionId = nutritionId;
        }

        public String getNutritionName() {
            return nutritionName;
        }

        public void setNutritionName(String nutritionName) {
            this.nutritionName = nutritionName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}
