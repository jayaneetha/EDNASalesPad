package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colombosoft.ednasalespad.db_tables.AttendanceTable;
import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.model.Dealer;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreAttendance {

    private static final String TAG = "StoreAttendance";

    private AttendanceTable baseAttendance;

    public SQLiteDatabase storeDealerListInDB(SQLiteDatabase databaseInstance ,List<Attendance> attendances){

        baseAttendance = new AttendanceTable();

        for(Attendance attendance : attendances){

            baseAttendance.insertAttendance(databaseInstance,attendance);
        }

        return databaseInstance;
    }
}
