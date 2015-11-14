package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.ProductBrand;
import com.colombosoft.ednasalespad.model.ProductLevel;

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


    public SQLiteDatabase insertProductLavel(SQLiteDatabase databaseInstance, ProductLevel productLevel){

        ContentValues productLevelInsert = new ContentValues();
        productLevelInsert.put("ProductLevelId", productLevel.getProductLevelId());
        productLevelInsert.put("ProductLevelName",productLevel.getProductLevelName());
        productLevelInsert.put("ProductSubCategory", productLevel.getProductSubCategory());
        productLevelInsert.put("AddedDate", productLevel.getAddedDate());
        productLevelInsert.put("AddedBy", productLevel.getAddedBy());
        productLevelInsert.put("LastModified", productLevel.getLastModified());
        productLevelInsert.put("LastModifiedBy", productLevel.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_LEVEL_TABLE_NAME , null, productLevelInsert);

        return databaseInstance;

    }
}
