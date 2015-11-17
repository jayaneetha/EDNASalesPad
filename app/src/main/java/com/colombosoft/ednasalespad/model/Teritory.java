package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class Teritory {

    private int TeritoryId;
    private String TeritoryName;
    private String TeritoryCode;
    private int AreaId;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private Area Area;

    public Teritory() {
    }

    public Teritory(int teritoryId, String teritoryName, String teritoryCode, int areaId, String addedDate, String addedBy, String lastModified, String lastModifiedBy, com.colombosoft.ednasalespad.model.Area area) {
        TeritoryId = teritoryId;
        TeritoryName = teritoryName;
        TeritoryCode = teritoryCode;
        AreaId = areaId;
        AddedDate = addedDate;
        AddedBy = addedBy;
        LastModified = lastModified;
        LastModifiedBy = lastModifiedBy;
        Area = area;
    }

    public int getTeritoryId() {
        return TeritoryId;
    }

    public void setTeritoryId(int teritoryId) {
        TeritoryId = teritoryId;
    }

    public String getTeritoryName() {
        return TeritoryName;
    }

    public void setTeritoryName(String teritoryName) {
        TeritoryName = teritoryName;
    }

    public String getTeritoryCode() {
        return TeritoryCode;
    }

    public void setTeritoryCode(String teritoryCode) {
        TeritoryCode = teritoryCode;
    }

    public int getAreaId() {
        return AreaId;
    }

    public void setAreaId(int areaId) {
        AreaId = areaId;
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

    public Area getArea() {
        return Area;
    }

    public void setArea(Area area) {
        Area = area;
    }
}
