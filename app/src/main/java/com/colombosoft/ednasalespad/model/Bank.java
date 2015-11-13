package com.colombosoft.ednasalespad.model;

import java.util.List;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class Bank {

    private int BankId;
    private String BankName;
    private String Address;
    private String BankCode;
    private List<Branch> Branches;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public int getBankId() {
        return BankId;
    }

    public void setBankId(int bankId) {
        BankId = bankId;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        BankCode = bankCode;
    }

    public List<Branch> getBranches() {
        return Branches;
    }

    public void setBranches(List<Branch> branches) {
        Branches = branches;
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
