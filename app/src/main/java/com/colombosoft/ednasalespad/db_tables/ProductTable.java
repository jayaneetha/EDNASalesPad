package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductTable {

    public static final String PRODUCT_TABLE_NAME = "tbl_product";

    public static final String PRODUCT_TABLE =  "CREATE TABLE IF NOT EXISTS "
                                                    + "tbl_product" + " ("
                                                    + "ProductId" + " varchar(32) primary key, "
                                                    + "ProductLongName" + " varchar(32), "
                                                    + "ProductShortName" + " varchar(32), "
                                                    + "ProductCode" + " varchar(32), "
                                                    + "ProductPrice" + " double(32), "
                                                    + "ProductbarCode" + " varchar(32), "
                                                    + "ProductImageUrl" + " varchar(32), "
                                                    + "ProductExternalCode" + " varchar(32), "
                                                    + "PriorityNumber" + " integer(32), "
                                                    + "IsActive" + " boolean, "
                                                    + "DiscountAvailable" + " boolean, "
                                                    + "NoOfUnitsInCartoon" + " integer(32), "
                                                    + "ProductWeight" + " double(32), "
                                                    + "DisplayInCartoon" + " varchar(32), "
                                                    + "ProductCategoryId" + " integer(32), "
                                                    + "NoOfItemsInUnit" + " integer(32), "
                                                    + "AddedDate" + " varchar(32), "
                                                    + "AddedBy" + " varchar(32), "
                                                    + "LastModified" + " varchar(32), "
                                                    + "LastModifiedBy" + " varchar(32) "
                                                    + ")";

}
