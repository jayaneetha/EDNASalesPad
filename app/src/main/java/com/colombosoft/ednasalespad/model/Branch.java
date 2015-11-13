package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class Branch {

    private int BankBranchId;
    private String Branch;
    private String BranchCode;
    private int BankId;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public int getBankBranchId() {
        return BankBranchId;
    }

    public void setBankBranchId(int bankBranchId) {
        BankBranchId = bankBranchId;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String branchCode) {
        BranchCode = branchCode;
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

    public int getBankId() {
        return BankId;
    }

    public void setBankId(int bankId) {
        BankId = bankId;
    }
}
