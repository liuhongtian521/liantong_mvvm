package com.askia.coremodel.datamodel.http.entities.consume;

import java.io.Serializable;

public class HttpConsumeConfigBean extends CBaseResponseData {

    /**
     * result : {"schoolName":"建昌职专","compulsoryConfirmation":false,"countdown":3,"abnormalCooling":3,"turnOnRotation":true,"schoolLogo":"http://218.60.2.195:89/appdownload/dishesImg/W1.png","tentant":"这里有家串店","password":"111111"}
     * timestamp : 1604318013877
     */

    private ResultBean result;
    private long timestamp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean implements Serializable {
        /**
         * schoolName : 建昌职专
         * compulsoryConfirmation : false
         * countdown : 3
         * abnormalCooling : 3
         * isOrder:0/1  null  ""=1
         * turnOnRotation : true
         * schoolLogo : http://218.60.2.195:89/appdownload/dishesImg/W1.png
         * tentant : 这里有家串店
         * password : 111111
         * returnScreensaverTime:10
         */

        private String schoolName;
        private boolean compulsoryConfirmation;
        private int abnormalCooling;
        private boolean turnOnRotation;
        private String isOrder;
        private String schoolLogo;
        private String tentant;
        private String password;
        private String schoolCode;
        private int returnScreensaverTime;
        private int countdown;

        public int getReturnScreensaverTime() {
            return returnScreensaverTime;
        }

        public void setReturnScreensaverTime(int returnScreensaverTime) {
            this.returnScreensaverTime = returnScreensaverTime;
        }

        public String getIsOrder() {
            return isOrder;
        }

        public void setIsOrder(String isOrder) {
            this.isOrder = isOrder;
        }

        public String getSchoolCode() {
            return schoolCode;
        }

        public void setSchoolCode(String schoolCode) {
            this.schoolCode = schoolCode;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public boolean isCompulsoryConfirmation() {
            return compulsoryConfirmation;
        }

        public void setCompulsoryConfirmation(boolean compulsoryConfirmation) {
            this.compulsoryConfirmation = compulsoryConfirmation;
        }

        public int getCountdown() {
            return countdown;
        }

        public void setCountdown(int countdown) {
            this.countdown = countdown;
        }

        public int getAbnormalCooling() {
            return abnormalCooling;
        }

        public void setAbnormalCooling(int abnormalCooling) {
            this.abnormalCooling = abnormalCooling;
        }

        public boolean isTurnOnRotation() {
            return turnOnRotation;
        }

        public void setTurnOnRotation(boolean turnOnRotation) {
            this.turnOnRotation = turnOnRotation;
        }

        public String getSchoolLogo() {
            return schoolLogo;
        }

        public void setSchoolLogo(String schoolLogo) {
            this.schoolLogo = schoolLogo;
        }

        public String getTentant() {
            return tentant;
        }

        public void setTentant(String tentant) {
            this.tentant = tentant;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "schoolName='" + schoolName + '\'' +
                    ", compulsoryConfirmation=" + compulsoryConfirmation +
                    ", abnormalCooling=" + abnormalCooling +
                    ", turnOnRotation=" + turnOnRotation +
                    ", isOrder='" + isOrder + '\'' +
                    ", schoolLogo='" + schoolLogo + '\'' +
                    ", tentant='" + tentant + '\'' +
                    ", password='" + password + '\'' +
                    ", schoolCode='" + schoolCode + '\'' +
                    ", returnScreensaverTime=" + returnScreensaverTime +
                    ", countdown=" + countdown +
                    '}';
        }
    }
}
