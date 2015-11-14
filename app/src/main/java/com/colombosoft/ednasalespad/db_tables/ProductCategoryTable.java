package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Product;
import com.colombosoft.ednasalespad.model.ProductCategory;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductCategoryTable {

    public static final String PRODUCT_CATEGORY_TABLE_NAME = "tbl_product_category";

    public static final String PRODUCT_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                                + "tbl_product_category" + " ("
                                                                + "ProductCategoryId" + " integer(32) primary key, "
                                                                + "ProductCategoryName " + " varchar(32), "
                                                                + "ProductCategoryShortCode" + " varchar(32), "
                                                                + "ProductBrandId " + " integer(32), "
                                                                + "AddedDate" + " varchar(32), "
                                                                + "AddedBy" + " varchar(32), "
                                                                + "LastModified" + " varchar(32), "
                                                                + "LastModifiedBy" + " varchar(32) "
                                                                + ")";

    public SQLiteDatabase insertProductCategory(SQLiteDatabase databaseInstance, ProductCategory productCategory){

        ContentValues productCategoryInsert = new ContentValues();
        productCategoryInsert.put("ProductCategoryId", productCategory.getProductCategoryId());
        productCategoryInsert.put("ProductCategoryName",productCategory.getProductCategoryName());
        productCategoryInsert.put("ProductCategoryShortCode", productCategory.getProductCategoryShortCode());
        productCategoryInsert.put("ProductBrandId", productCategory.getProductBrandId());
        productCategoryInsert.put("AddedDate", productCategory.getAddedDate());
        productCategoryInsert.put("AddedBy", productCategory.getAddedBy());
        productCategoryInsert.put("LastModified", productCategory.getLastModified());
        productCategoryInsert.put("LastModifiedBy", productCategory.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_CATEGORY_TABLE_NAME , null, productCategoryInsert);

        return databaseInstance;

    }

}
