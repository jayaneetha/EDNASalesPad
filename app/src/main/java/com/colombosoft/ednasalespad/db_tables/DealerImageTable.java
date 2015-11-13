package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DealerImageTable {

    public static final String DEALER_IMAGE_TABLE_NAME = "tbl_dealer_image";

    public static final String DEALER_IMAGE_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_dealer_image" + " ("
                                                            + "DocumentId" + "  varchar(32) primary key, "
                                                            + "File" + " varchar(32), "
                                                            + "DealerId" + " varchar(32) "
                                                            + ")";

}
