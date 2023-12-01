package com.askia.coremodel.datamodel.http.entities.consume;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

import java.util.List;

public class HttpConsumeBannerBean extends BaseResponseData
{


    /**
     * success : true
     * message : 操作成功！
     * code : 200
     * result : ["http://218.60.2.195:89/appdownload/dishesImg/W1.png","http://172.16.75.249:9000/syerzhong/dishesImg/W3.jpg","http://172.16.75.249:9000/syerzhong/dishesImg/W2.jpg","http://172.16.75.249:9000/syerzhong/dishesImg/2.jpg","http://218.60.2.195:89/appdownload/dishesImg/W2.png","http://218.60.2.195:89/appdownload/dishesImg/W3.png","http://218.60.2.195:89/appdownload/dishesImg/W4.png","http://218.60.2.195:89/appdownload/dishesImg/W5.png","http://218.60.2.195:89/appdownload/dishesImg/W6.png","http://218.60.2.195:89/appdownload/dishesImg/W7.png"]
     * timestamp : 1604990174414
     */

    private boolean success;
    private String message;
    private int code;
    private long timestamp;
    private List<String> result;

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

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
