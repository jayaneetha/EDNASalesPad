package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class AgentTable {

    public static final String AGENT_TABLE_NAME = "tbl_agent";

    public static final String AGENT_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                    + "tbl_agent" + " ("
                                                    + "AgentId" + "  varchar(50) primary key, "
                                                    + "AgentName" + " varchar(32), "
                                                    + "AreaCode" + " varchar(32), "
                                                    + "AgentLocation_Lat" + " double, "
                                                    + "AgentLocation_Long" + " double, "
                                                    + "BusinessRegistration" + " varchar(32), "
                                                    + "OwnerName" + " varchar(32), "
                                                    + "AgentAddress" + " varchar(32), "
                                                    + "AgentTp" + " varchar(32), "
                                                    + "VATNumber" + " varchar(32), "
                                                    + "BankGurantyStart" + " varchar(32), "
                                                    + "BankGurantyAmount" + " double, "
                                                    + "BankGurantyEnd" + " varchar(32), "
                                                    + "Active" + " boolean(32), "
                                                    + "ASMId" + " varchar(32), "
                                                    + "VehicleNumber" + " varchar(32), "
                                                    + "VehicleLocation_Lat" + " varchar(32), "
                                                    + "VehicleLocation_Long" + " varchar(32), "
                                                    + "MarketReturnLocation_Lat" + " varchar(32), "
                                                    + "MarketReturnLocation_Long" + " varchar(32), "
                                                    + "IsMainLocation" + " boolean(32), "
                                                    + "IsVehicleLocation" + " boolean(32), "
                                                    + "TeritoryId" + " int(32), "
                                                    + "AddedDate" + " varchar(32), "
                                                    + "AddedBy" + " varchar(32), "
                                                    + "LastModified" + " varchar(32), "
                                                    + "LastModifiedBy" + " varchar(32) "
                                                    + ")";

}
