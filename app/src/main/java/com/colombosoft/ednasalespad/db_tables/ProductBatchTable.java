package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.ProductBatch;
import com.colombosoft.ednasalespad.model.ProductBrand;

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

    public SQLiteDatabase insertProductBatch(SQLiteDatabase databaseInstance, ProductBatch batch){

        ContentValues productBatchInsert = new ContentValues();
        productBatchInsert.put("ProductBatchId", batch.getProductBatchId());
        productBatchInsert.put("ShortCode",batch.getShortCode());
        productBatchInsert.put("AgentPrice", batch.getAgentPrice());
        productBatchInsert.put("DealerPrice", batch.getDealerPrice());
        productBatchInsert.put("ConsumerPrice", batch.getConsumerPrice());
        productBatchInsert.put("ProductExpirateTimeInMonths", batch.getProductExpirateTimeInMonths());
        productBatchInsert.put("NoReturnDiscount", batch.getNoReturnDiscount());
        productBatchInsert.put("ProductPoints", batch.getProductPoints());
        productBatchInsert.put("ProductMargin", batch.getProductMargin());
        productBatchInsert.put("ProductId", batch.getProductId());
        productBatchInsert.put("AddedDate", batch.getAddedDate());
        productBatchInsert.put("AddedBy", batch.getAddedBy());
        productBatchInsert.put("LastModified", batch.getLastModified());
        productBatchInsert.put("LastModifiedBy", batch.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_BATCH_TABLE_NAME , null, productBatchInsert);
        return databaseInstance;

    }



}
