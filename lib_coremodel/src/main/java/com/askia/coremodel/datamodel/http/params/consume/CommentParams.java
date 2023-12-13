package com.askia.coremodel.datamodel.http.params.consume;

import com.askia.coremodel.datamodel.http.params.BaseRequestParams;

public class CommentParams extends BaseRequestParams {

    private String argContId;
    private String argCommContent;

    public String getArgContId() {
        return argContId == null ? "" : argContId;
    }

    public void setArgContId(String argContId) {
        this.argContId = argContId;
    }

    public String getArgCommContent() {
        return argCommContent == null ? "" : argCommContent;
    }

    public void setArgCommContent(String argCommContent) {
        this.argCommContent = argCommContent;
    }
}
