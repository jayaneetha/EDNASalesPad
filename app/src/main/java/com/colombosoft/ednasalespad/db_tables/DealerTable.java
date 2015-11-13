package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Dealer;

import java.util.List;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DealerTable {

    public static final String DEALER_TABLE_NAME = "tbl_dealer";

    public static final String DEALER_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_dealer" + " ("
                                                        + "DealerId" + "  varchar(32), "
                                                        + "Name" + " varchar(32),"
                                                        + "Address" + " varchar(32), "
                                                        + "District" + " varchar(32), "
                                                        + "DSDivision" + " varchar(32), "
                                                        + "GNDivision" + " varchar(32), "
                                                        + "DealerClassId" + " integer(32), "
                                                        + "RouteId" + " integer(32), "
                                                        + "OpenBalance" + " double(32), "
                                                        + "ContactPerson" + " varchar(32), "
                                                        + "LandNumber" + " varchar(32), "
                                                        + "MobileNumber" + " varchar(32), "
                                                        + "Status" + " boolean(32), "
                                                        + "AccountOpendate" + " varchar(32), "
                                                        + "Blocked" + " boolean(32), "
                                                        + "CreditLimit" + " double(32), "
                                                        + "OutstandingBalance" + " double(32), "
                                                        + "Comments" + " varchar(32), "
                                                        + "ShowcaseGiven" + " boolean, "
                                                        + "ShowcaseGivendate" + " varchar(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

    public SQLiteDatabase insertDealer(SQLiteDatabase databaseInstance, Dealer route){

        ContentValues routeInsert = new ContentValues();
        routeInsert.put("DealerId", route.getRouteId());
        routeInsert.put("Name",route.getName());
        routeInsert.put("Address", route.getAddress());
        routeInsert.put("District", route.getDistrict());
        routeInsert.put("DSDivision", route.getDSDivision());
        routeInsert.put("GNDivision", route.getGNDivision());
        routeInsert.put("DealerClassId", route.getDealerClassId());
        routeInsert.put("RouteId", route.getRouteId());
        routeInsert.put("OpenBalance", route.getOpenBalance());
        routeInsert.put("ContactPerson", route.getContactPerson());
        routeInsert.put("LandNumber", route.getLandNumber());
        routeInsert.put("MobileNumber", route.getMobileNumber());
        routeInsert.put("Status", route.isStatus());
        routeInsert.put("AccountOpendate", route.getAccountOpendate());
        routeInsert.put("Blocked", route.isBlocked());
        routeInsert.put("CreditLimit", route.getCreditLimit());
        routeInsert.put("OutstandingBalance", route.getOutstandingBalance());
        routeInsert.put("Comments", route.getComments());
        routeInsert.put("ShowcaseGiven", route.isShowcaseGiven());
        routeInsert.put("ShowcaseGivendate", route.getShowcaseGivendate());
        routeInsert.put("AddedDate", route.getAddedDate());
        routeInsert.put("AddedBy", route.getAddedBy());
        routeInsert.put("LastModified", route.getLastModified());
        routeInsert.put("LastModifiedBy", route.getLastModifiedBy());
        databaseInstance.insert(DEALER_TABLE_NAME , null, routeInsert);
        return databaseInstance;

    }

}
