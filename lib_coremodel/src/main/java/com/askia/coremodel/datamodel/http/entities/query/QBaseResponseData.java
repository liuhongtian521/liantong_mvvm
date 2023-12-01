package com.askia.coremodel.datamodel.http.entities.query;

import com.askia.coremodel.datamodel.http.ResponseCode;

import java.io.Serializable;

/**
 * 基础类
 */
public class QBaseResponseData implements Serializable
{
    private int code;
    private String message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isError()
    {
        return code != QResponseCode.ResponseSuccessCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
