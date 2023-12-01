package com.askia.coremodel.datamodel.database.db;

import io.realm.RealmConfiguration;

public class ConsumeRealmConstant
{
    public static int VERSON = 3;
    public static RealmConfiguration sRealmConfiguration;

    public static RealmConfiguration getRealmConfig()
    {
        if(sRealmConfiguration == null)
            sRealmConfiguration =  new RealmConfiguration.Builder()
                    .name("SUPERMARKET")
                    .schemaVersion(ConsumeRealmConstant.VERSON)
                    .build();

        return sRealmConfiguration;
    }
}
