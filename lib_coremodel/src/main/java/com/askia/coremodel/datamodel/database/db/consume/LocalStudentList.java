package com.askia.coremodel.datamodel.database.db.consume;

import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;

import java.util.List;

public class LocalStudentList extends CBaseResponseData {
    public List<StudentCardInfo> getList() {
        return list;
    }

    public void setList(List<StudentCardInfo> list) {
        this.list = list;
    }

    private List<StudentCardInfo> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;
}
