package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpStudentGetFoodBean extends BaseResponseData
{

    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : [{"mealDate":"2020-11-05","studentName":"学生","studentCode":"11111","studentId":"1111","orderId":"13","orderNo":"131313","orderMoney":"44.00","className":"20级5班","mealType":"1","accountMoney":"111.00","consumeType":"2","consumed":"0","url":"http://218.60.2.195:89/appdownload/dishesImg/2.jpg","orderDetailInfo":[{"dishesName":"麻辣豆腐盖饭套餐","dishesId":"4","dishesMoney":"23.00","amount":"1","dishesUrl":"http://172.16.75.249:9000/syerzhong/dishesImg/W3.jpg"}]},{"mealDate":"2020-11-05","studentName":"学生","studentCode":"11111","studentId":"1111","orderId":"10","orderNo":"101010","orderMoney":"16.00","className":"20级5班","mealType":"1","accountMoney":"111.00","consumeType":"1","consumed":"0","url":"http://218.60.2.195:89/appdownload/dishesImg/2.jpg","orderDetailInfo":[{"dishesName":"酱茄子盖饭套餐","dishesId":"5","dishesMoney":"24.00","amount":"1","dishesUrl":"http://172.16.75.249:9000/syerzhong/dishesImg/W4.jpg"}]},{"mealDate":"2020-11-05","studentName":"学生","studentCode":"11111","studentId":"1111","orderId":"1","orderNo":"111","orderMoney":"32.00","className":"20级5班","mealType":"1","accountMoney":"111.00","consumeType":"2","consumed":"0","url":"http://218.60.2.195:89/appdownload/dishesImg/2.jpg","orderDetailInfo":[{"dishesName":"宫保鸡丁盖饭套餐","dishesId":"1","dishesMoney":"20.00","amount":"1","dishesUrl":"http://172.16.75.249:9000/syerzhong/dishesImg/W1.jpg"},{"dishesName":"宫保鸡丁盖饭套餐","dishesId":"1","dishesMoney":"20.00","amount":"1","dishesUrl":"http://172.16.75.249:9000/syerzhong/dishesImg/W1.jpg"},{"dishesName":"红烧狮子头","dishesId":"7","dishesMoney":"15.00","amount":"1","dishesUrl":"http://172.16.75.249:9000/syerzhong/dishesImg/W6.jpg"}]}]
     * timestamp : 1604555077722
     */

    private boolean success;
    private String message;
    private int code;
    private long timestamp;
    private List<OrderResultInfo> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<OrderResultInfo> getResult() {
        return result;
    }

    public void setResult(List<OrderResultInfo> result) {
        this.result = result;
    }

}
