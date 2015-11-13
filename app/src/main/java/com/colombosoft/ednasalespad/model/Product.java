package com.colombosoft.ednasalespad.model;

import java.util.List;

/**
 * Created by DragonSlayer on 11/3/2015.
 */
public class Product {

    private String ProductId;
    private String ProductLongName;
    private String ProductShortName;
    private String ProductCode;
    private double ProductPrice;
    private String ProductbarCode;
    private String ProductImageUrl;
    private String ProductExternalCode;
    private int PriorityNumber;
    private boolean IsActive;
    private boolean DiscountAvailable;
    private int NoOfUnitsInCartoon;
    private double ProductWeight;
    private String DisplayInCartoon;
    private int ProductCategoryId;
    private int ProductUnitId;
    private int NoOfItemsInUnit;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;
    private ProductCategory ProductCategory;
    private List<ProductBatch> ProductBatches;
    private ProductUnit ProductUnit;

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductLongName() {
        return ProductLongName;
    }

    public void setProductLongName(String productLongName) {
        ProductLongName = productLongName;
    }

    public String getProductShortName() {
        return ProductShortName;
    }

    public void setProductShortName(String productShortName) {
        ProductShortName = productShortName;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductbarCode() {
        return ProductbarCode;
    }

    public void setProductbarCode(String productbarCode) {
        ProductbarCode = productbarCode;
    }

    public String getProductImageUrl() {
        return ProductImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        ProductImageUrl = productImageUrl;
    }

    public String getProductExternalCode() {
        return ProductExternalCode;
    }

    public void setProductExternalCode(String productExternalCode) {
        ProductExternalCode = productExternalCode;
    }

    public int getPriorityNumber() {
        return PriorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        PriorityNumber = priorityNumber;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setIsActive(boolean isActive) {
        IsActive = isActive;
    }

    public boolean isDiscountAvailable() {
        return DiscountAvailable;
    }

    public void setDiscountAvailable(boolean discountAvailable) {
        DiscountAvailable = discountAvailable;
    }

    public int getNoOfUnitsInCartoon() {
        return NoOfUnitsInCartoon;
    }

    public void setNoOfUnitsInCartoon(int noOfUnitsInCartoon) {
        NoOfUnitsInCartoon = noOfUnitsInCartoon;
    }

    public double getProductWeight() {
        return ProductWeight;
    }

    public void setProductWeight(double productWeight) {
        ProductWeight = productWeight;
    }

    public String getDisplayInCartoon() {
        return DisplayInCartoon;
    }

    public void setDisplayInCartoon(String displayInCartoon) {
        DisplayInCartoon = displayInCartoon;
    }
    public int getProductCategoryId() {
        return ProductCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        ProductCategoryId = productCategoryId;
    }
    public int getProductUnitId() {
        return ProductUnitId;
    }

    public void setProductUnitId(int productUnitId) {
        ProductUnitId = productUnitId;
    }

    public int getNoOfItemsInUnit() {
        return NoOfItemsInUnit;
    }

    public void setNoOfItemsInUnit(int noOfItemsInUnit) {
        NoOfItemsInUnit = noOfItemsInUnit;
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

    public ProductCategory getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        ProductCategory = productCategory;
    }

    public List<ProductBatch> getProductBatches() {
        return ProductBatches;
    }

    public void setProductBatches(List<ProductBatch> productBatches) {
        ProductBatches = productBatches;
    }

    public ProductUnit getProductUnit() {
        return ProductUnit;
    }

    public void setProductUnit(ProductUnit productUnit) {
        ProductUnit = productUnit;
    }
}
