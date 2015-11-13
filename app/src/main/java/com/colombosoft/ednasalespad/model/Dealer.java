package com.colombosoft.ednasalespad.model;

import java.util.List;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class Dealer {

    private String DealerId;
    private String Name;
    private String Address;
    private String District;
    private String DSDivision;
    private String GNDivision;
    private int DealerClassId;
    private DealerClass DealerClass;
    private int RouteId;
    private Route Route;
    private double OpenBalance;
    private String ContactPerson;
    private String LandNumber;
    private String MobileNumber;
    private boolean Status;
    private String AccountOpendate;
    private boolean Blocked;
    private double CreditLimit;
    private double OutstandingBalance;
    private String Comments;
    private boolean ShowcaseGiven;
    private String ShowcaseGivendate;
    private GeoCordinates GeoCordinates;
    private List<DealerImage> DealerImages;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public String getDealerId() {
        return DealerId;
    }

    public void setDealerId(String dealerId) {
        DealerId = dealerId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getDSDivision() {
        return DSDivision;
    }

    public void setDSDivision(String DSDivision) {
        this.DSDivision = DSDivision;
    }

    public String getGNDivision() {
        return GNDivision;
    }

    public void setGNDivision(String GNDivision) {
        this.GNDivision = GNDivision;
    }

    public int getDealerClassId() {
        return DealerClassId;
    }

    public void setDealerClassId(int dealerClassId) {
        DealerClassId = dealerClassId;
    }

    public DealerClass getDealerClass() {
        return DealerClass;
    }

    public void setDealerClass(DealerClass dealerClass) {
        DealerClass = dealerClass;
    }

    public int getRouteId() {
        return RouteId;
    }

    public void setRouteId(int routeId) {
        RouteId = routeId;
    }

    public Route getRoute() {
        return Route;
    }

    public void setRoute(Route route) {
        Route = route;
    }

    public double getOpenBalance() {
        return OpenBalance;
    }

    public void setOpenBalance(double openBalance) {
        OpenBalance = openBalance;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String contactPerson) {
        ContactPerson = contactPerson;
    }

    public String getLandNumber() {
        return LandNumber;
    }

    public void setLandNumber(String landNumber) {
        LandNumber = landNumber;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getAccountOpendate() {
        return AccountOpendate;
    }

    public void setAccountOpendate(String accountOpendate) {
        AccountOpendate = accountOpendate;
    }

    public boolean isBlocked() {
        return Blocked;
    }

    public void setBlocked(boolean blocked) {
        Blocked = blocked;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        CreditLimit = creditLimit;
    }

    public double getOutstandingBalance() {
        return OutstandingBalance;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        OutstandingBalance = outstandingBalance;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public boolean isShowcaseGiven() {
        return ShowcaseGiven;
    }

    public void setShowcaseGiven(boolean showcaseGiven) {
        ShowcaseGiven = showcaseGiven;
    }

    public String getShowcaseGivendate() {
        return ShowcaseGivendate;
    }

    public void setShowcaseGivendate(String showcaseGivendate) {
        ShowcaseGivendate = showcaseGivendate;
    }

    public GeoCordinates getGeoCordinates() {
        return GeoCordinates;
    }

    public void setGeoCordinates(GeoCordinates geoCordinates) {
        GeoCordinates = geoCordinates;
    }

    public List<DealerImage> getDealerImages() {
        return DealerImages;
    }

    public void setDealerImages(List<DealerImage> dealerImages) {
        DealerImages = dealerImages;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
