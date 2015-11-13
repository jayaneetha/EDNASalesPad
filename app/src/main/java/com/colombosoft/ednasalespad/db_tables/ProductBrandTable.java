package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductBrandTable {

    public static final String PRODUCT_BRAND_TABLE_NAME = "tbl_product_brand";

    public static final String PRODUCT_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                                + "tbl_product_brand" + " ("
                                                                + "ProductBrandId" + " integer(32) primary key, "
                                                                + "ProductBrandName" + " varchar(32), "
                                                                + "ProductBrandShortCode" + " varchar(32), "
                                                                + "AddedDate" + " varchar(32), "
                                                                + "AddedBy" + " varchar(32), "
                                                                + "LastModified" + " varchar(32), "
                                                                + "LastModifiedBy" + " varchar(32) "
                                                                + ")";

}
