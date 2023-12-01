package com.askia.coremodel.datamodel.http.entities.query;

import com.askia.coremodel.datamodel.http.entities.BaseResponseData;

/**
 * Create bt she:
 *
 * @date 2020/12/1
 */
public class LastMealDateData extends QBaseResponseData {
    private String lastdate;

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}
