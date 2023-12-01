package com.askia.coremodel.datamodel.http.entities.query;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

/**
 * Create bt she:
 * 营养分析
 *
 * @date 2020/10/27
 */
public class NutritionAnalysisData extends QBaseResponseData {
    private List<DataBean> result;

    public List<DataBean> getResult() {
        return result;
    }

    public void setResult(List<DataBean> result) {
        this.result = result;
    }

    public static class DataBean {
        private String content;//营养含量
        private String dishesName;//餐品名称
        private String nutritionId;//营养id
        private String nutritionName;//营养名称
        private String remark;//餐品营养分析

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
