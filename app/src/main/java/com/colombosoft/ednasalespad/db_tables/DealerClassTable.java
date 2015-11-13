package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DealerClassTable {

    public static final String DEALER_CLASS_TABLE_NAME = "tbl_dealer_class";

    public static final String DEALER_CLASS_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_dealer_class" + " ("
                                                        + "DealerClassId" + "  int(32) primary key, "
                                                        + "DealerClassName" + " varchar(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

}
