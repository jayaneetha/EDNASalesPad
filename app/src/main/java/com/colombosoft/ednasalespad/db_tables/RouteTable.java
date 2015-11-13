package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Route;

import java.util.List;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class RouteTable {


    public static final String ROUTE_TABLE_NAME = "tbl_route";



    public static final String ROUTE_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_route" + " ("
                                                        + "RouteId" + " integer(32), "
                                                        + "RouteName" + " varchar(32), "
                                                        + "RouteCode" + " varchar(32), "
                                                        + "TeritoryId" + " integer(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";


    public SQLiteDatabase insertRoute(SQLiteDatabase databaseInstance, Route route){


        ContentValues routeInsert = new ContentValues();



            routeInsert.put("RouteId", route.getRouteId());
            routeInsert.put("RouteName", route.getRouteName());
            routeInsert.put("RouteCode", route.getRouteCode());
            routeInsert.put("TeritoryId", route.getTeritoryId());
            routeInsert.put("AddedDate", route.getAddedDate());
            routeInsert.put("AddedBy", route.getAddedBy());
            routeInsert.put("LastModified", route.getLastModified());
            routeInsert.put("LastModifiedBy", route.getLastModifiedBy());
            databaseInstance.insert(ROUTE_TABLE_NAME , null, routeInsert);

        return databaseInstance;
    }
}
