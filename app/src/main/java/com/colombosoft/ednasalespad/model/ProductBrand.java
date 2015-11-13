package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class ProductBrand {

    private int ProductBrandId;
    private String ProductBrandName;
    private String ProductBrandShortCode;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public int getProductBrandId() {
        return ProductBrandId;
    }

    public void setProductBrandId(int productBrandId) {
        ProductBrandId = productBrandId;
    }

    public String getProductBrandName() {
        return ProductBrandName;
    }

    public void setProductBrandName(String productBrandName) {
        ProductBrandName = productBrandName;
    }

    public String getProductBrandShortCode() {
        return ProductBrandShortCode;
    }

    public void setProductBrandShortCode(String productBrandShortCode) {
        ProductBrandShortCode = productBrandShortCode;
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
}
