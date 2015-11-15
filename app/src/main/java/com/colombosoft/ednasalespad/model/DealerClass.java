package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class DealerClass {

    private int DealerClassId;
    private String DealerClassName;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public DealerClass() {
    }

    public DealerClass(int dealerClassId, String dealerClassName) {
        DealerClassId = dealerClassId;
        DealerClassName = dealerClassName;
    }


    public int getDealerClassId() {
        return DealerClassId;
    }

    public void setDealerClassId(int dealerClassId) {
        DealerClassId = dealerClassId;
    }

    public String getDealerClassName() {
        return DealerClassName;
    }

    public void setDealerClassName(String dealerClassName) {
        DealerClassName = dealerClassName;
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
