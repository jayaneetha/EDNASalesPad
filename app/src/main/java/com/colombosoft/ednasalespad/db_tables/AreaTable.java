package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Area;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class AreaTable {

    public static final String AREA_TABLE_NAME = "tbl_area";
    
    public static final String AREA_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_area" + " ("
                                                        + "AreaId" + "  int(32), "
                                                        + "AreaName" + " varchar(32), "
                                                        + "AreaCode" + " varchar(32), "
                                                        + "RegionId" + " int(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";



    public SQLiteDatabase insertArea(SQLiteDatabase databaseInstance , Area area){

        ContentValues areaInsert = new ContentValues();

        areaInsert.put("AreaId", area.getAreaId());
        areaInsert.put("AreaName", area.getAreaId());
        areaInsert.put("AreaCode", area.getAreaId());
        areaInsert.put("RegionId", area.getAreaId());
        areaInsert.put("AddedDate", area.getAreaId());
        areaInsert.put("AddedBy", area.getAreaId());
        areaInsert.put("LastModified", area.getAreaId());
        areaInsert.put("LastModifiedBy", area.getAreaId());

        databaseInstance.insert(AREA_TABLE_NAME, null, areaInsert);

        return databaseInstance;

    }

}
