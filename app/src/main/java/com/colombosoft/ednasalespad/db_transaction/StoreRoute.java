package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colombosoft.ednasalespad.db_tables.AreaTable;
import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.db_tables.RegionTable;
import com.colombosoft.ednasalespad.db_tables.RouteTable;
import com.colombosoft.ednasalespad.db_tables.TeritoryTable;
import com.colombosoft.ednasalespad.model.Area;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Route;

import java.util.List;

/**
 * Created by DragonSlayer on 11/7/2015.
 */
public class StoreRoute {

    private final static String TAG = "StoreRoute";

    private RouteTable basRroute;
    private TeritoryTable baseTeritory;
    private AreaTable baseArea;
    private RegionTable baseRegion;

    public SQLiteDatabase storeRouteListInDB(SQLiteDatabase databaseInstance ,List<Route> routes){

        basRroute = new RouteTable();

        for(Route route : routes){

            basRroute.insertRoute(databaseInstance , route);

            if(route.getTeritory() != null){

                baseTeritory = new TeritoryTable();
                baseTeritory.insertTeritory(databaseInstance , route.getTeritory());

                if(route.getTeritory().getArea() != null ){

                    baseArea = new AreaTable();
                    baseArea.insertArea(databaseInstance,route.getTeritory().getArea());

                    if(route.getTeritory().getArea().getRegion() != null){

                        baseRegion = new RegionTable();
                        baseRegion.insertRegion(databaseInstance ,route.getTeritory().getArea().getRegion());

                    }
                }
            }
        }

        Log.d(TAG, "**************** successfully added route *****************");
        return databaseInstance;

    }


}
