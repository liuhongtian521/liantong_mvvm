package com.askia.coremodel.datamodel.database.db.consume;

import com.askia.coremodel.datamodel.http.entities.consume.CBaseResponseData;

import java.util.List;

public class LocalConsume extends CBaseResponseData {
    public List<ShoppingRecord> getList() {
        return list;
    }

    public void setList(List<ShoppingRecord> list) {
        this.list = list;
    }

    private List<ShoppingRecord> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;
}
