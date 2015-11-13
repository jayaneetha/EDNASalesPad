package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductUnitTable {

    public static final String PRODUCT_UNIT_TABLE_NAME = "tbl_product_unit";

    public static final String PRODUCT_UNIT_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_product_unit" + " ("
                                                            + "ProductUnitId" + " integer(32) primary key, "
                                                            + "ProductUnitName" + " varchar(32), "
                                                            + "AddedDate" + " varchar(32), "
                                                            + "AddedBy" + " varchar(32), "
                                                            + "LastModified" + " varchar(32), "
                                                            + "LastModifiedBy" + " varchar(32) "
                                                            + ")";

}
