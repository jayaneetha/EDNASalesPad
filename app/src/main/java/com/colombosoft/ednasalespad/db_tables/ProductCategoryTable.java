package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductCategoryTable {

    public static final String PRODUCT_CATEGORY_TABLE_NAME = "tbl_product_category";

    public static final String PRODUCT_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                                + "tbl_product_category" + " ("
                                                                + "ProductCategoryId" + " integer(32) primary key, "
                                                                + "ProductCategoryName " + " varchar(32), "
                                                                + "ProductCategoryShortCode" + " varchar(32), "
                                                                + "ProductBrandId " + " integer(32), "
                                                                + "AddedDate" + " varchar(32), "
                                                                + "AddedBy" + " varchar(32), "
                                                                + "LastModified" + " varchar(32), "
                                                                + "LastModifiedBy" + " varchar(32) "
                                                                + ")";

}
