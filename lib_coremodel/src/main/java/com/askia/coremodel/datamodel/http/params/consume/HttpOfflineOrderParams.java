package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

import java.util.List;

public class HttpOfflineOrderParams extends BaseRequestParams {
    /**
     * "cardNo": "",
     * "code": "",
     * "getOrderType": "",
     * "img": "",
     * "money": 0,
     * "orderId": "",
     * "sn": ""
     */


    private String cardNo;
    private String code;
    private String getOrderType;
    private String img;
    private String money;
    private String orderId;
    private String sn;
    private String studentName;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGetOrderType() {
        return getOrderType;
    }

    public void setGetOrderType(String getOrderType) {
        this.getOrderType = getOrderType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "HttpOfflineOrderParams{" +
                "cardNo='" + cardNo + '\'' +
                ", code='" + code + '\'' +
                ", getOrderType='" + getOrderType + '\'' +
                ", img='" + img + '\'' +
                ", money='" + money + '\'' +
                ", orderId='" + orderId + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }

    public static class OrderDetailInfoBean {
        /**
         * amount :
         * dishesId :
         * dishesMoney :
         * dishesName :
         * dishesUrl :
         */

        private String amount;
        private String dishesId;
        private String dishesMoney;
        private String dishesName;
        private String dishesUrl;
        private String dishesclassify;

        // 在列表中的更新下标
        private int position;


        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getDishesclassify() {
            return dishesclassify;
        }

        public void setDishesclassify(String dishesclassify) {
            this.dishesclassify = dishesclassify;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getDishesId() {
            return dishesId;
        }

        public void setDishesId(String dishesId) {
            this.dishesId = dishesId;
        }

        public String getDishesMoney() {
            return dishesMoney;
        }

        public void setDishesMoney(String dishesMoney) {
            this.dishesMoney = dishesMoney;
        }

        public String getDishesName() {
            return dishesName;
        }

        public void setDishesName(String dishesName) {
            this.dishesName = dishesName;
        }

        public String getDishesUrl() {
            return dishesUrl;
        }

        public void setDishesUrl(String dishesUrl) {
            this.dishesUrl = dishesUrl;
        }
    }
}
