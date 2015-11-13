package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Teritory;



/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class TeritoryTable {


    public static final String TERITORY_TABLE_NAME = "tbl_teritory";

    public static final String TERITORY_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_teritory" + " ("
                                                            + "TeritoryId" + "  int(32), "
                                                            + "TeritoryName" + " varchar(32), "
                                                            + "TeritoryCode" + " varchar(32), "
                                                            + "AreaId" + " int(32), "
                                                            + "AddedDate" + " varchar(32), "
                                                            + "AddedBy" + " varchar(32), "
                                                            + "LastModified" + " varchar(32), "
                                                            + "LastModifiedBy" + " varchar(32) "
                                                            + ")";


    public SQLiteDatabase insertTeritory(SQLiteDatabase databaseInstance ,Teritory teritories){

        ContentValues dealerRouteTeritoryInsert = new ContentValues();
        dealerRouteTeritoryInsert.put("TeritoryId", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("TeritoryName", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("TeritoryCode", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("AreaId", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("AddedDate", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("AddedBy", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("LastModified", teritories.getTeritoryId());
        dealerRouteTeritoryInsert.put("LastModifiedBy", teritories.getTeritoryId());

        databaseInstance.insert(TERITORY_TABLE_NAME, null, dealerRouteTeritoryInsert);

        return databaseInstance;
    }

}
