package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductUnit;

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

    public SQLiteDatabase insertProductUnit(SQLiteDatabase databaseInstance, ProductUnit product){

        ContentValues productUniInsert = new ContentValues();
        productUniInsert.put("ProductUnitId", product.getProductUnitId());
        productUniInsert.put("ProductUnitName",product.getProductUnitName());
        productUniInsert.put("AddedDate", product.getAddedDate());
        productUniInsert.put("AddedBy", product.getAddedBy());
        productUniInsert.put("LastModified", product.getLastModified());
        productUniInsert.put("LastModifiedBy", product.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_UNIT_TABLE_NAME , null, productUniInsert);

        return databaseInstance;

    }

}
