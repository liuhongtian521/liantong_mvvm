package com.askia.coremodel.datamodel.http.entities.consume;

import java.io.Serializable;

public class CaptchaResultBean implements Serializable {


    /**
     * key : 51bc2adf4722272dbdfd691f2ae13610
     * image : data:image/png;base64,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
     */

    private String key;
    private String image;

    private String error;
    private String message;

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error == null ? "" : error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
