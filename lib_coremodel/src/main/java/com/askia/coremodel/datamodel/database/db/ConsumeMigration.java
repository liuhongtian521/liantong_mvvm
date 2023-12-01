package com.askia.coremodel.datamodel.database.db;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class ConsumeMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();
        if(newVersion > oldVersion)
        {
            if (oldVersion == 1L) {
                schema.get("StudentCardInfo").addField("cardStatus",String.class);
                schema.get("StudentCardInfo").addField("accountStatus",String.class);
                oldVersion++;
            }
            if (oldVersion == 2L){
                schema.get("ShoppingRecord").addField("refundUser",String.class);
                schema.get("ShoppingRecord").addField("orderUser",String.class);
                oldVersion++;
            }
          /*  // 版本1迁移到版本2
            if (oldVersion == 1L) {
            schema.create("MessageBean").addPrimaryKey("msgId").addField("msgType", String.class).addField("publishTime", String.class).addField("title", String.class)
            .addField("content", String.class).addField("isRead", Boolean.class);
            oldVersion++;
            }
            // 版本2迁移到版本3
            if (oldVersion == 2L) {
            *//*schema.create("Person").addField("name",String.class)
                    .addField("age",int.class);
            oldVersion++;*//*
                schema.get("MessageBean").addField("msgName", String.class);
                oldVersion++;
            }
            // 版本3迁移到版本4
            if (oldVersion == 3L) {
            *//*schema.create("Person").addField("name",String.class)
                    .addField("age",int.class);
            oldVersion++;*//*
                schema.get("MessageBean").addField("user", String.class);
                oldVersion++;
            }
            // 版本4迁移到版本5
            if (oldVersion == 4L) {
            *//*schema.create("Person").addField("name",String.class)
                    .addField("age",int.class);
            oldVersion++;*//*
                schema.get("TransFilesRecord").addField("lastModifyTime", String.class).addField("type", String.class);
                oldVersion++;
            }

            // 版本5迁移到版本6
            if (oldVersion == 5L) {
                schema.create("TaxnewsHistoryRecord").addField("content", String.class);
                oldVersion++;
            }

            // 版本6迁移到版本7
            if (oldVersion == 6L) {
                schema.get("TransFilesRecord").removeField("id");
                oldVersion++;
            }

            // 版本7迁移到版本8
            if (oldVersion == 7L) {
                schema.get("TransFilesRecord").addPrimaryKey("filePath");
                oldVersion++;
            }*/
        }

    }
}
