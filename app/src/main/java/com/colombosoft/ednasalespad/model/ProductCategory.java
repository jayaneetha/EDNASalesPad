package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class ProductCategory {

    private int ProductCategoryId;
    private String ProductCategoryName;
    private String ProductCategoryShortCode;
    private int ProductBrandId;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private ProductBrand ProductBrand;

    public int getProductCategoryId() {
        return ProductCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        ProductCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return ProductCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        ProductCategoryName = productCategoryName;
    }

    public String getProductCategoryShortCode() {
        return ProductCategoryShortCode;
    }

    public void setProductCategoryShortCode(String productCategoryShortCode) {
        ProductCategoryShortCode = productCategoryShortCode;
    }

    public int getProductBrandId() {
        return ProductBrandId;
    }

    public void setProductBrandId(int productBrandId) {
        ProductBrandId = productBrandId;
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

    public ProductBrand getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(ProductBrand productBrand) {
        ProductBrand = productBrand;
    }
}
