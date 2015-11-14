package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.model.DealerClass;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DealerClassTable {

    public static final String DEALER_CLASS_TABLE_NAME = "tbl_dealer_class";

    public static final String DEALER_CLASS_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_dealer_class" + " ("
                                                        + "DealerClassId" + "  int(32) primary key, "
                                                        + "DealerClassName" + " varchar(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

    public SQLiteDatabase insertDealerClass(SQLiteDatabase databaseInstance , DealerClass dealerClass){

        ContentValues dealerClassInsert = new ContentValues();

        dealerClassInsert.put("DealerClassId", dealerClass.getDealerClassId());
        dealerClassInsert.put("DealerClassName", dealerClass.getDealerClassName());
        dealerClassInsert.put("AddedDate", dealerClass.getAddedBy());
        dealerClassInsert.put("AddedBy", dealerClass.getAddedBy());
        dealerClassInsert.put("LastModified",dealerClass.getLastModified());
        dealerClassInsert.put("LastModifiedBy",dealerClass.getLastModifiedBy());

        databaseInstance.insert(DEALER_CLASS_TABLE_NAME, null, dealerClassInsert);

        return databaseInstance;

    }

}
