package com.zdy.study.event;

// 当处理过程有异常时  需要客屏继续扫描人脸
public class GoContinueDetectEvent {

    private int type;
    private String name;
    private String money;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
