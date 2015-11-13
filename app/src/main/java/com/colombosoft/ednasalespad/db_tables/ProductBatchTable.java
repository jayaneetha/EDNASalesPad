package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductBatchTable {

    public static final String PRODUCT_BATCH_TABLE_NAME = "tbl_product_batch";

    public static final String PRODUCT_BATCH_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_product_batch" + " ("
                                                            + "ProductBatchId" + " varchar(32) primary key, "
                                                            + "ShortCode" + " varchar(32), "
                                                            + "AgentPrice" + " double(32), "
                                                            + "DealerPrice" + " double(32), "
                                                            + "ConsumerPrice" + " double(32), "
                                                            + "ProductExpirateTimeInMonths" + " integer(32), "
                                                            + "NoReturnDiscount" + " double(32), "
                                                            + "ProductPoints" + " integer(32), "
                                                            + "ProductMargin" + " double(32), "
                                                            + "DiscountAllowance" + " double(32), "
                                                            + "ProductId" + " varchar(32), "
                                                            + "AddedDate" + " varchar(32), "
                                                            + "AddedBy" + " varchar(32), "
                                                            + "LastModified" + " varchar(32), "
                                                            + "LastModifiedBy" + " varchar(32) "
                                                            + ")";
}
