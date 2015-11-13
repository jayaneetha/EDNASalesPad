package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductLevelTable {

    public static final String PRODUCT_LEVEL_TABLE_NAME = "tbl_product_level";

    public static final String PRODUCT_LEVEL_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_product_level" + " ("
                                                            + "ProductLevelId" + " integer(32) primary key, "
                                                            + "ProductLevelName" + " varchar(32), "
                                                            + "ProductSubCategory" + " varchar(32), "
                                                            + "AddedDate" + " varchar(32), "
                                                            + "AddedBy" + " varchar(32), "
                                                            + "LastModified" + " varchar(32), "
                                                            + "LastModifiedBy" + " varchar(32) "
                                                            + ")";
}
