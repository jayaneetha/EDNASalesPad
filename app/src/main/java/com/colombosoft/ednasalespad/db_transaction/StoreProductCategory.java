package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.AttendanceTable;
import com.colombosoft.ednasalespad.db_tables.ProductCategoryTable;
import com.colombosoft.ednasalespad.model.Attendance;
import com.colombosoft.ednasalespad.model.ProductCategory;

import java.util.List;

/**
 * Created by DragonSlayer on 11/13/2015.
 */
public class StoreProductCategory {

    private static final String TAG = "StoreProductCategory";

    private ProductCategoryTable baseProductCategory;

    public SQLiteDatabase storeProductCategoryListInDB(SQLiteDatabase databaseInstance ,List<ProductCategory> categories){

        baseProductCategory = new ProductCategoryTable();

        for(ProductCategory category : categories){

            baseProductCategory.insertProductCategory(databaseInstance, category);
        }

        return databaseInstance;
    }
}
