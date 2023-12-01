package com.zdy.study.event;

public class UploadOfflineRecordEvent {
    // 1 上传中 2 已完成 3 用户取消 4 异常终端
    private int type;
    private int total;
    private int finishCount;
    private int errorCount;
    private String errorMsg;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(int finishCount) {
        this.finishCount = finishCount;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
