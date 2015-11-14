package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.AttendanceTable;
import com.colombosoft.ednasalespad.db_tables.DealerClassTable;
import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.model.DealerClass;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreDealerClass {

    private static final String TAG = "StoreDealerClass";

    private DealerClassTable baseDealerClass;

    public SQLiteDatabase storeDealerClassListInDB(SQLiteDatabase databaseInstance ,List<DealerClass> dealerClasses){

        baseDealerClass = new DealerClassTable();

        for(DealerClass dealerClass : dealerClasses){

            baseDealerClass.insertDealerClass(databaseInstance, dealerClass);
        }

        return databaseInstance;
    }
}
