package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.ProductBrand;
import com.colombosoft.ednasalespad.model.ProductCategory;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductBrandTable {

    public static final String PRODUCT_BRAND_TABLE_NAME = "tbl_product_brand";

    public static final String PRODUCT_BRAND_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                                + "tbl_product_brand" + " ("
                                                                + "ProductBrandId" + " integer(32) primary key, "
                                                                + "ProductBrandName" + " varchar(32), "
                                                                + "ProductBrandShortCode" + " varchar(32), "
                                                                + "AddedDate" + " varchar(32), "
                                                                + "AddedBy" + " varchar(32), "
                                                                + "LastModified" + " varchar(32), "
                                                                + "LastModifiedBy" + " varchar(32) "
                                                                + ")";

    public SQLiteDatabase insertProductBrand(SQLiteDatabase databaseInstance, ProductBrand productBrand){

        ContentValues productBrandInsert = new ContentValues();
        productBrandInsert.put("ProductBrandId", productBrand.getProductBrandId());
        productBrandInsert.put("ProductBrandName",productBrand.getProductBrandName());
        productBrandInsert.put("ProductBrandShortCode", productBrand.getProductBrandShortCode());
        productBrandInsert.put("AddedDate", productBrand.getAddedDate());
        productBrandInsert.put("AddedBy", productBrand.getAddedBy());
        productBrandInsert.put("LastModified", productBrand.getLastModified());
        productBrandInsert.put("LastModifiedBy", productBrand.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_BRAND_TABLE_NAME , null, productBrandInsert);

        return databaseInstance;

    }

}
