package com.zdy.study.event;

import java.io.Serializable;

/**
 * Create bt she:
 *
 * @date 2020/12/23
 */
public class ConfirmationEvent implements Serializable {
    private String orderId;
    private String studentId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
