package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.DealerClassTable;
import com.colombosoft.ednasalespad.db_tables.ProductBrandTable;
import com.colombosoft.ednasalespad.model.DealerClass;
import com.colombosoft.ednasalespad.model.ProductBrand;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreProductBrand {

    private static final String TAG = "StoreProductBrand";

    private ProductBrandTable baseProductBrand;

    public SQLiteDatabase storeDealerClassListInDB(SQLiteDatabase databaseInstance ,List<ProductBrand> productBrands){

        baseProductBrand = new ProductBrandTable();

        for(ProductBrand productBrand : productBrands){

            baseProductBrand.insertProductBrand(databaseInstance, productBrand);
        }

        return databaseInstance;
    }


}
