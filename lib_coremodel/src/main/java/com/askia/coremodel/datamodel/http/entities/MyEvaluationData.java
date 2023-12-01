package com.askia.coremodel.datamodel.http.entities;

import java.util.List;

public class MyEvaluationData extends BaseResponseData
{
    /**
     * pageNum : 1
     * totalNum : 5
     * totalPage : 1
     * data : [{"level":"5"，"stuName":"里斯","meal_desc":"顶呱呱","eval_time":"2019-09-18 15:14:38","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿"},{"level":"3","meal_desc":"一般","eval_time":"2019-09-18 15:12:01","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿"},{"level":"1.5","meal_desc":"不好吃","eval_time":"2019-08-30 09:40:46","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿"},{"level":"4.5","meal_desc":"好吃","eval_time":"2019-08-30 09:38:50","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿"},{"level":"5","meal_desc":"好吃","eval_time":"2019-08-30 09:37:50","meal_name":"A套餐","meal_constitute":"土豆+茄子+西红柿"}]
     */

    private int pageNum;
    private int totalNum;
    private int totalPage;
    private List<DataBean> data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * level : 5
         * meal_desc : 顶呱呱
         * eval_time : 2019-09-18 15:14:38
         * meal_name : A套餐
         * meal_constitute : 土豆+茄子+西红柿
         * stuName:里斯
         */

        private String level;
        private String meal_desc;
        private String eval_time;
        private  String stuName;
        private String meal_name;
        private String meal_constitute;

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMeal_desc() {
            return meal_desc;
        }

        public void setMeal_desc(String meal_desc) {
            this.meal_desc = meal_desc;
        }

        public String getEval_time() {
            return eval_time;
        }

        public void setEval_time(String eval_time) {
            this.eval_time = eval_time;
        }

        public String getMeal_name() {
            return meal_name;
        }

        public void setMeal_name(String meal_name) {
            this.meal_name = meal_name;
        }

        public String getMeal_constitute() {
            return meal_constitute;
        }

        public void setMeal_constitute(String meal_constitute) {
            this.meal_constitute = meal_constitute;
        }
    }
}
