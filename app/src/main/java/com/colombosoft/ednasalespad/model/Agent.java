package com.colombosoft.ednasalespad.model;

/**
 * Created by DragonSlayer on 11/4/2015.
 */
public class Agent {

    private String AgentId;
    private String AgentName;
    private String AgentCode;
    private AgentLocation AgentLocation;
    private String BusinessRegistration;
    private String OwnerName;
    private String AgentAddress;
    private String AgentTp;
    private String VATNumber;
    private String BankGurantyStart;
    private double BankGurantyAmount;
    private String BankGurantyEnd;
    private boolean Active;
    private String ASMId;
    private String VehicleNumber;
    private VehicleLocation VehicleLocation;
    private MarketReturnLocation MarketReturnLocation;
    private boolean IsMainLocation;
    private boolean IsVehicleLocation;
    private int TeritoryId;
    private Teritory Teritory;
    private String AddedDate;
    private String AddedBy;
    private String LastModified;
    private String LastModifiedBy;

    public String getAgentId() {
        return AgentId;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public String getAgentName() {
        return AgentName;
    }

    public void setAgentName(String agentName) {
        AgentName = agentName;
    }

    public String getAgentCode() {
        return AgentCode;
    }

    public void setAgentCode(String agentCode) {
        AgentCode = agentCode;
    }

    public AgentLocation getAgentLocation() {
        return AgentLocation;
    }

    public void setAgentLocation(AgentLocation agentLocation) {
        AgentLocation = agentLocation;
    }

    public String getBusinessRegistration() {
        return BusinessRegistration;
    }

    public void setBusinessRegistration(String businessRegistration) {
        BusinessRegistration = businessRegistration;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getAgentAddress() {
        return AgentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        AgentAddress = agentAddress;
    }

    public String getAgentTp() {
        return AgentTp;
    }

    public void setAgentTp(String agentTp) {
        AgentTp = agentTp;
    }

    public String getVATNumber() {
        return VATNumber;
    }

    public void setVATNumber(String VATNumber) {
        this.VATNumber = VATNumber;
    }

    public String getBankGurantyStart() {
        return BankGurantyStart;
    }

    public void setBankGurantyStart(String bankGurantyStart) {
        BankGurantyStart = bankGurantyStart;
    }

    public double getBankGurantyAmount() {
        return BankGurantyAmount;
    }

    public void setBankGurantyAmount(double bankGurantyAmount) {
        BankGurantyAmount = bankGurantyAmount;
    }

    public String getBankGurantyEnd() {
        return BankGurantyEnd;
    }

    public void setBankGurantyEnd(String bankGurantyEnd) {
        BankGurantyEnd = bankGurantyEnd;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getASMId() {
        return ASMId;
    }

    public void setASMId(String ASMId) {
        this.ASMId = ASMId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleLocation getVehicleLocation() {
        return VehicleLocation;
    }

    public void setVehicleLocation(VehicleLocation vehicleLocation) {
        VehicleLocation = vehicleLocation;
    }

    public MarketReturnLocation getMarketReturnLocation() {
        return MarketReturnLocation;
    }

    public void setMarketReturnLocation(MarketReturnLocation marketReturnLocation) {
        MarketReturnLocation = marketReturnLocation;
    }

    public boolean isMainLocation() {
        return IsMainLocation;
    }

    public void setIsMainLocation(boolean isMainLocation) {
        IsMainLocation = isMainLocation;
    }

    public boolean isVehicleLocation() {
        return IsVehicleLocation;
    }

    public void setIsVehicleLocation(boolean isVehicleLocation) {
        IsVehicleLocation = isVehicleLocation;
    }

    public int getTeritoryId() {
        return TeritoryId;
    }

    public void setTeritoryId(int teritoryId) {
        TeritoryId = teritoryId;
    }

    public Teritory getTeritory() {
        return Teritory;
    }

    public void setTeritory(Teritory teritory) {
        Teritory = teritory;
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
