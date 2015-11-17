package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class Route {

    private int RouteId;
    private String RouteName;
    private String RouteCode;
    private int TeritoryId;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private Teritory Teritory;

    public Route() {
    }

    public Route(int routeId, String routeName, String routeCode, int teritoryId, String addedDate, String addedBy, String lastModified, String lastModifiedBy, com.colombosoft.ednasalespad.model.Teritory teritory) {
        RouteId = routeId;
        RouteName = routeName;
        RouteCode = routeCode;
        TeritoryId = teritoryId;
        AddedDate = addedDate;
        AddedBy = addedBy;
        LastModified = lastModified;
        LastModifiedBy = lastModifiedBy;
        Teritory = teritory;
    }


    public int getRouteId() {
        return RouteId;
    }

    public void setRouteId(int routeId) {
        RouteId = routeId;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }

    public String getRouteCode() {
        return RouteCode;
    }

    public void setRouteCode(String routeCode) {
        RouteCode = routeCode;
    }

    public int getTeritoryId() {
        return TeritoryId;
    }

    public void setTeritoryId(int teritoryId) {
        TeritoryId = teritoryId;
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

    public Teritory getTeritory() {
        return Teritory;
    }

    public void setTeritory(Teritory teritory) {
        Teritory = teritory;
    }
}
