package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.ProductTable;
import com.colombosoft.ednasalespad.db_tables.ProductUnitTable;
import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductUnit;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreProductUnit {

    private static final String TAG = "StoreProductUnit";

    private ProductUnitTable baseProduct;

    public SQLiteDatabase storeProductUnitListInDB(SQLiteDatabase databaseInstance ,List<ProductUnit> products){

        baseProduct = new ProductUnitTable();

        for(ProductUnit product : products){

            baseProduct.insertProductUnit(databaseInstance,product);
        }

        return databaseInstance;
    }
}
