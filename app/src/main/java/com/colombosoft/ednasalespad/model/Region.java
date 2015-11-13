package com.colombosoft.ednasalespad.model;

import java.util.List;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class Region {

    private int RegionId;
    private String RegionName;
    private String RegionCode;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private List<Area> Areas;

    public int getRegionId() {
        return RegionId;
    }

    public void setRegionId(int regionId) {
        RegionId = regionId;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public String getRegionCode() {
        return RegionCode;
    }

    public void setRegionCode(String regionCode) {
        RegionCode = regionCode;
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

    public List<Area> getAreas() {
        return Areas;
    }

    public void setAreas(List<Area> areas) {
        Areas = areas;
    }
}
