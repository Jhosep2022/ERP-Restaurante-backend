package com.erp.zkteco.dto;

import java.io.Serializable;

public class PersonnelPositionDto implements Serializable {

    private Long id;
    private String positionCode;
    private String positionName;
    private Boolean isDefault;
    private Long parentPositionId;
    private Long companyId;

    // Constructor vacío
    public PersonnelPositionDto() {}

    // Constructor completo
    public PersonnelPositionDto(Long id, String positionCode, String positionName, Boolean isDefault, Long parentPositionId, Long companyId) {
        this.id = id;
        this.positionCode = positionCode;
        this.positionName = positionName;
        this.isDefault = isDefault;
        this.parentPositionId = parentPositionId;
        this.companyId = companyId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Long getParentPositionId() {
        return parentPositionId;
    }

    public void setParentPositionId(Long parentPositionId) {
        this.parentPositionId = parentPositionId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "PersonnelPositionDto{" +
                "id=" + id +
                ", positionCode='" + positionCode + '\'' +
                ", positionName='" + positionName + '\'' +
                ", isDefault=" + isDefault +
                ", parentPositionId=" + parentPositionId +
                ", companyId=" + companyId +
                '}';
    }
}
