package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Product;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class ProductTable {

    public static final String PRODUCT_TABLE_NAME = "tbl_product";

    public static final String PRODUCT_TABLE =  "CREATE TABLE IF NOT EXISTS "
                                                    + "tbl_product" + " ("
                                                    + "ProductId" + " varchar(32) primary key, "
                                                    + "ProductLongName" + " varchar(32), "
                                                    + "ProductShortName" + " varchar(32), "
                                                    + "ProductCode" + " varchar(32), "
                                                    + "ProductPrice" + " double(32), "
                                                    + "ProductbarCode" + " varchar(32), "
                                                    + "ProductImageUrl" + " varchar(32), "
                                                    + "ProductExternalCode" + " varchar(32), "
                                                    + "PriorityNumber" + " integer(32), "
                                                    + "IsActive" + " boolean, "
                                                    + "DiscountAvailable" + " boolean, "
                                                    + "NoOfUnitsInCartoon" + " integer(32), "
                                                    + "ProductWeight" + " double(32), "
                                                    + "DisplayInCartoon" + " varchar(32), "
                                                    + "ProductCategoryId" + " integer(32), "
                                                    + "NoOfItemsInUnit" + " integer(32), "
                                                    + "AddedDate" + " varchar(32), "
                                                    + "AddedBy" + " varchar(32), "
                                                    + "LastModified" + " varchar(32), "
                                                    + "LastModifiedBy" + " varchar(32) "
                                                    + ")";


    public SQLiteDatabase insertProduct(SQLiteDatabase databaseInstance, Product product){

        ContentValues productInsert = new ContentValues();
        productInsert.put("ProductId", product.getProductId());
        productInsert.put("ProductLongName",product.getProductLongName());
        productInsert.put("ProductShortName", product.getProductShortName());
        productInsert.put("ProductCode", product.getProductCode());
        productInsert.put("ProductPrice", product.getProductPrice());
        productInsert.put("ProductbarCode", product.getProductbarCode());
        productInsert.put("ProductImageUrl", product.getProductImageUrl());
        productInsert.put("ProductExternalCode", product.getProductExternalCode());
        productInsert.put("PriorityNumber", product.getPriorityNumber());
        productInsert.put("IsActive", product.isActive());
        productInsert.put("DiscountAvailable", product.isDiscountAvailable());
        productInsert.put("NoOfUnitsInCartoon", product.getNoOfUnitsInCartoon());
        productInsert.put("ProductWeight", product.getProductWeight());
        productInsert.put("DisplayInCartoon", product.getDisplayInCartoon());
        productInsert.put("ProductCategoryId", product.getProductCategoryId());
        productInsert.put("NoOfItemsInUnit", product.getNoOfItemsInUnit());
        productInsert.put("AddedDate", product.getAddedDate());
        productInsert.put("AddedBy", product.getAddedBy());
        productInsert.put("LastModified", product.getLastModified());
        productInsert.put("LastModifiedBy", product.getLastModifiedBy());
        databaseInstance.insert(PRODUCT_TABLE_NAME , null, productInsert);

        return databaseInstance;

    }

}
