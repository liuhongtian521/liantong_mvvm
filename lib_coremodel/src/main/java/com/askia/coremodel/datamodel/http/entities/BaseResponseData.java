package com.askia.coremodel.datamodel.http.entities;

import com.askia.coremodel.datamodel.http.ResponseCode;

import java.io.Serializable;

public class BaseResponseData implements Serializable
{
    private int status;
    private String msg;

    public boolean isError()
    {
        return status != ResponseCode.ResponseSuccessCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
