package com.erp.zkteco.dto;

import java.io.Serializable;

public class PersonnelAreaDto implements Serializable {

    private Long id;
    private String areaCode;
    private String areaName;
    private Boolean isDefault;
    private Long parentAreaId;
    private Long companyId;
    private Integer deviceCount;
    private Integer employeeCount;

    // Constructor vacío
    public PersonnelAreaDto() {}

    // Constructor completo
    public PersonnelAreaDto(Long id, String areaCode, String areaName, Boolean isDefault, Long parentAreaId, Long companyId, Integer deviceCount, Integer employeeCount) {
        this.id = id;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.isDefault = isDefault;
        this.parentAreaId = parentAreaId;
        this.companyId = companyId;
        this.deviceCount = deviceCount;
        this.employeeCount = employeeCount;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Long getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(Long parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "PersonnelAreaDto{" +
                "id=" + id +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", isDefault=" + isDefault +
                ", parentAreaId=" + parentAreaId +
                ", companyId=" + companyId +
                ", deviceCount=" + deviceCount +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
