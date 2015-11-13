package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Region;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class RegionTable {

    public static final String REGION_TABLE_NAME = "tbl_region";

    public static final String REGION_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_region" + " ("
                                                        + "RegionId" + "  int(32), "
                                                        + "RegionName" + " varchar(32), "
                                                        + "RegionCode" + " varchar(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

    public SQLiteDatabase insertRegion(SQLiteDatabase databaseInstance, Region region){

        ContentValues regionInsert = new ContentValues();

        regionInsert.put("RegionId", region.getRegionId());
        regionInsert.put("RegionName", region.getRegionId());
        regionInsert.put("RegionCode", region.getRegionId());
        regionInsert.put("AddedDate", region.getRegionId());
        regionInsert.put("AddedBy", region.getRegionId());
        regionInsert.put("LastModified", region.getRegionId());
        regionInsert.put("LastModifiedBy", region.getRegionId());

        databaseInstance.insert(REGION_TABLE_NAME, null, regionInsert);

        return databaseInstance;
    }

}
