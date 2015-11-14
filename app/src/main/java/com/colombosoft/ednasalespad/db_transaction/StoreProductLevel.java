package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.ProductLevelTable;
import com.colombosoft.ednasalespad.db_tables.ProductTable;
import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductLevel;

import java.util.List;

/**
 * Created by DragonSlayer on 11/14/2015.
 */
public class StoreProductLevel {

    private static final String TAG = "StoreProductLevel";

    private ProductLevelTable baseProduct;

    public SQLiteDatabase storeProductListInDB(SQLiteDatabase databaseInstance ,List<ProductLevel> products){

        baseProduct = new ProductLevelTable();

        for(ProductLevel product : products){

            baseProduct.insertProductLavel(databaseInstance,product);
        }

        return databaseInstance;
    }
}
