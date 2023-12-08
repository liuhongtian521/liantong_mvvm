package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class CourseQueryResponseBean {

    /**
     * code : 200
     * success : true
     * data : [{"curriculumNum":"4","week":"四","classesId":"1654379304946704386","calendarDate":"2023-06-01"},{"curriculumNum":"3","week":"五","classesId":"1654379304946704386","calendarDate":"2023-06-02"},{"curriculumNum":"3","week":"六","classesId":"1654379304946704386","calendarDate":"2023-06-03"},{"curriculumNum":"2","week":"日","classesId":"1654379304946704386","calendarDate":"2023-06-04"},{"curriculumNum":"0","week":"一","classesId":"","calendarDate":"2023-06-05"},{"curriculumNum":"0","week":"二","classesId":"","calendarDate":"2023-06-06"},{"curriculumNum":"0","week":"三","classesId":"","calendarDate":"2023-06-07"},{"curriculumNum":"0","week":"四","classesId":"","calendarDate":"2023-06-08"},{"curriculumNum":"0","week":"五","classesId":"","calendarDate":"2023-06-09"},{"curriculumNum":"0","week":"六","classesId":"","calendarDate":"2023-06-10"},{"curriculumNum":"0","week":"日","classesId":"","calendarDate":"2023-06-11"},{"curriculumNum":"0","week":"一","classesId":"","calendarDate":"2023-06-12"},{"curriculumNum":"0","week":"二","classesId":"","calendarDate":"2023-06-13"},{"curriculumNum":"0","week":"三","classesId":"","calendarDate":"2023-06-14"},{"curriculumNum":"1","week":"四","classesId":"1654379304946704386","calendarDate":"2023-06-15"},{"curriculumNum":"0","week":"五","classesId":"","calendarDate":"2023-06-16"},{"curriculumNum":"0","week":"六","classesId":"","calendarDate":"2023-06-17"},{"curriculumNum":"0","week":"日","classesId":"","calendarDate":"2023-06-18"},{"curriculumNum":"0","week":"一","classesId":"","calendarDate":"2023-06-19"},{"curriculumNum":"0","week":"二","classesId":"","calendarDate":"2023-06-20"},{"curriculumNum":"0","week":"三","classesId":"","calendarDate":"2023-06-21"},{"curriculumNum":"0","week":"四","classesId":"","calendarDate":"2023-06-22"},{"curriculumNum":"0","week":"五","classesId":"","calendarDate":"2023-06-23"},{"curriculumNum":"0","week":"六","classesId":"","calendarDate":"2023-06-24"},{"curriculumNum":"0","week":"日","classesId":"","calendarDate":"2023-06-25"},{"curriculumNum":"0","week":"一","classesId":"","calendarDate":"2023-06-26"},{"curriculumNum":"0","week":"二","classesId":"","calendarDate":"2023-06-27"},{"curriculumNum":"0","week":"三","classesId":"","calendarDate":"2023-06-28"},{"curriculumNum":"0","week":"四","classesId":"","calendarDate":"2023-06-29"},{"curriculumNum":"0","week":"五","classesId":"","calendarDate":"2023-06-30"}]
     * msg : 操作成功
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * curriculumNum : 4
         * week : 四
         * classesId : 1654379304946704386
         * calendarDate : 2023-06-01
         */

        private String curriculumNum;
        private String week;
        private String classesId;
        private String calendarDate;

        public String getCurriculumNum() {
            return curriculumNum;
        }

        public void setCurriculumNum(String curriculumNum) {
            this.curriculumNum = curriculumNum;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getClassesId() {
            return classesId;
        }

        public void setClassesId(String classesId) {
            this.classesId = classesId;
        }

        public String getCalendarDate() {
            return calendarDate;
        }

        public void setCalendarDate(String calendarDate) {
            this.calendarDate = calendarDate;
        }
    }
}
