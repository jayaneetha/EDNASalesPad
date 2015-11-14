package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.db_tables.ProductTable;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Product;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreProduct {

    private static final String TAG = "StoreProduct";

    private ProductTable baseProduct;

    public SQLiteDatabase storeProductListInDB(SQLiteDatabase databaseInstance ,List<Product> products){

        baseProduct = new ProductTable();

        for(Product product : products){

            baseProduct.insertProduct(databaseInstance,product);
        }

        return databaseInstance;
    }
}
