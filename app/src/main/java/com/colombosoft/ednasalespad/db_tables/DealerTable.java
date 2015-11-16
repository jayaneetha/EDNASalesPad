package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Dealer;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DealerTable {

    public static final String DEALER_TABLE_NAME = "tbl_dealer";

    public static final String DEALER_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_dealer" + " ("
                                                        + "DealerId" + "  varchar(40), "
                                                        + "Name" + " varchar(32),"
                                                        + "Address" + " varchar(32), "
                                                        + "District" + " varchar(32), "
                                                        + "DSDivision" + " varchar(32), "
                                                        + "GNDivision" + " varchar(32), "
                                                        + "DealerClassId" + " integer(32), "
                                                        + "RouteId" + " integer(32), "
                                                        + "OpenBalance" + " double, "
                                                        + "ContactPerson" + " varchar(32), "
                                                        + "LandNumber" + " varchar(32), "
                                                        + "MobileNumber" + " varchar(32), "
                                                        + "Status" + " boolean, "
                                                        + "AccountOpendate" + " varchar(32), "
                                                        + "Blocked" + " boolean, "
                                                        + "CreditLimit" + " double, "
                                                        + "OutstandingBalance" + " double, "
                                                        + "Comments" + " varchar(32), "
                                                        + "ShowcaseGiven" + " boolean, "
                                                        + "ShowcaseGivendate" + " varchar(32), "
                                                        + "AgentLocation_Lat" + " double, "
                                                        + "AgentLocation_Long" + " double, "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

    public SQLiteDatabase insertDealer(SQLiteDatabase databaseInstance, Dealer dealer){

        ContentValues routeInsert = new ContentValues();
        routeInsert.put("DealerId", dealer.getDealerId());
        routeInsert.put("Name",dealer.getName());
        routeInsert.put("Address", dealer.getAddress());
        routeInsert.put("District", dealer.getDistrict());
        routeInsert.put("DSDivision", dealer.getDSDivision());
        routeInsert.put("GNDivision", dealer.getGNDivision());
        routeInsert.put("DealerClassId", dealer.getDealerClassId());
        routeInsert.put("RouteId", dealer.getRouteId());
        routeInsert.put("OpenBalance", dealer.getOpenBalance());
        routeInsert.put("ContactPerson", dealer.getContactPerson());
        routeInsert.put("LandNumber", dealer.getLandNumber());
        routeInsert.put("MobileNumber", dealer.getMobileNumber());
        routeInsert.put("Status", dealer.isStatus());
        routeInsert.put("AccountOpendate", dealer.getAccountOpendate());
        routeInsert.put("Blocked", dealer.isBlocked());
        routeInsert.put("CreditLimit", dealer.getCreditLimit());
        routeInsert.put("OutstandingBalance", dealer.getOutstandingBalance());
        routeInsert.put("Comments", dealer.getComments());
        routeInsert.put("ShowcaseGiven", dealer.isShowcaseGiven());
        routeInsert.put("ShowcaseGivendate", dealer.getShowcaseGivendate());
        routeInsert.put("AgentLocation_Lat", dealer.getGeoCordinates().getLat());
        routeInsert.put("AgentLocation_Long", dealer.getGeoCordinates().getLong());
        routeInsert.put("AddedDate", dealer.getAddedDate());
        routeInsert.put("AddedBy", dealer.getAddedBy());
        routeInsert.put("LastModified", dealer.getLastModified());
        routeInsert.put("LastModifiedBy", dealer.getLastModifiedBy());
        databaseInstance.insert(DEALER_TABLE_NAME , null, routeInsert);
        return databaseInstance;

    }

}
