package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class ProductBatch {

    private String ProductBatchId;
    private String ShortCode;
    private double AgentPrice;
    private double DealerPrice;
    private double ConsumerPrice;
    private int ProductExpirateTimeInMonths;
    private double NoReturnDiscount ;
    private int ProductPoints ;
    private double ProductMargin;
    private double DiscountAllowance;
    private String ProductId;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public String getProductBatchId() {
        return ProductBatchId;
    }

    public void setProductBatchId(String productBatchId) {
        ProductBatchId = productBatchId;
    }

    public String getShortCode() {
        return ShortCode;
    }

    public void setShortCode(String shortCode) {
        ShortCode = shortCode;
    }

    public double getAgentPrice() {
        return AgentPrice;
    }

    public void setAgentPrice(double agentPrice) {
        AgentPrice = agentPrice;
    }

    public double getDealerPrice() {
        return DealerPrice;
    }

    public void setDealerPrice(double dealerPrice) {
        DealerPrice = dealerPrice;
    }

    public double getConsumerPrice() {
        return ConsumerPrice;
    }

    public void setConsumerPrice(double consumerPrice) {
        ConsumerPrice = consumerPrice;
    }

    public int getProductExpirateTimeInMonths() {
        return ProductExpirateTimeInMonths;
    }

    public void setProductExpirateTimeInMonths(int productExpirateTimeInMonths) {
        ProductExpirateTimeInMonths = productExpirateTimeInMonths;
    }

    public double getNoReturnDiscount() {
        return NoReturnDiscount;
    }

    public void setNoReturnDiscount(double noReturnDiscount) {
        NoReturnDiscount = noReturnDiscount;
    }

    public int getProductPoints() {
        return ProductPoints;
    }

    public void setProductPoints(int productPoints) {
        ProductPoints = productPoints;
    }

    public double getProductMargin() {
        return ProductMargin;
    }

    public void setProductMargin(double productMargin) {
        ProductMargin = productMargin;
    }

    public double getDiscountAllowance() {
        return DiscountAllowance;
    }

    public void setDiscountAllowance(double discountAllowance) {
        DiscountAllowance = discountAllowance;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
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
