package com.colombosoft.ednasalespad.model;

import java.util.List;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class ProductLevel {

    private int ProductLevelId;
    private String ProductLevelName;
    private String ProductSubCategory;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private List<Product> Products;

    public int getProductLevelId() {
        return ProductLevelId;
    }

    public void setProductLevelId(int productLevelId) {
        ProductLevelId = productLevelId;
    }

    public String getProductLevelName() {
        return ProductLevelName;
    }

    public void setProductLevelName(String productLevelName) {
        ProductLevelName = productLevelName;
    }

    public String getProductSubCategory() {
        return ProductSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        ProductSubCategory = productSubCategory;
    }
    public String getAddedDate() {
        return AddedDate;
    }

    public void setAddedDate(String addedDate) {
        AddedDate = addedDate;
    }

    public String getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(String addedBy) {
        AddedBy = addedBy;
    }

    public String getLastModified() {
        return LastModified;
    }

    public void setLastModified(String lastModified) {
        LastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return LastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        LastModifiedBy = lastModifiedBy;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
