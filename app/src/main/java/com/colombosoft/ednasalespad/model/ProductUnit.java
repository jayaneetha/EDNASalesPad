package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class ProductUnit {

    private int ProductUnitId;
    private String ProductUnitName;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public int getProductUnitId() {
        return ProductUnitId;
    }

    public void setProductUnitId(int productUnitId) {
        ProductUnitId = productUnitId;
    }

    public String getProductUnitName() {
        return ProductUnitName;
    }

    public void setProductUnitName(String productUnitName) {
        ProductUnitName = productUnitName;
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
