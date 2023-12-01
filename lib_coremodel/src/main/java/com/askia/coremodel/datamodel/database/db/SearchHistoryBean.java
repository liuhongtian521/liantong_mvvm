package com.askia.coremodel.datamodel.database.db;

import io.realm.RealmObject;

/**
 * Created by qinyy on 2019/3/6.
 */

public class SearchHistoryBean extends RealmObject
{
    private String content;

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
