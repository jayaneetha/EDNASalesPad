package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.ProductBatchTable;
import com.colombosoft.ednasalespad.db_tables.ProductTable;
import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductBatch;

import java.util.List;

/**
 * Created by DragonSlayer on 11/14/2015.
 */
public class StoreProductBatch {

    private static final String TAG = "StoreProductBatch";

    private ProductBatchTable baseProductBatch;

    public SQLiteDatabase storeProductBatchListInDB(SQLiteDatabase databaseInstance ,List<ProductBatch> products){

        baseProductBatch = new ProductBatchTable();

        for(ProductBatch product : products){

            baseProductBatch.insertProductBatch(databaseInstance, product);
        }

        return databaseInstance;
    }
}
