package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Area;
import com.colombosoft.ednasalespad.model.Attendance;

/**
 * Created by DragonSlayer on 11/11/2015.
 */
public class AttendanceTable {

    public static final String ATTENDANCE_TABLE_NAME = "tbl_attendance";

    public static final String ATTENDANCE_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                    + "tbl_attendance" + " ("
                                                    + "Id" + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
                                                    + "Lattitude" + "  double, "
                                                    + "Longtude" + " double, "
                                                    + "DateAndTime" + " varchar(32), "
                                                    + "Type" + " int(32), "
                                                    + "IsSync" + " boolean"
                                                    + ")";


    public SQLiteDatabase insertAttendance(SQLiteDatabase databaseInstance , Attendance attendance){

        ContentValues attendenceInsert = new ContentValues();

        attendenceInsert.put("Lattitude", attendance.getLocation().getLat());
        attendenceInsert.put("Longtude", attendance.getLocation().getLong());
        attendenceInsert.put("DateAndTime", attendance.getDateAndTime());
        attendenceInsert.put("Type", attendance.getType());
        attendenceInsert.put("IsSync",attendance.isSync());

        databaseInstance.insert(ATTENDANCE_TABLE_NAME, null, attendenceInsert);

        return databaseInstance;

    }


}
