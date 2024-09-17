package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnel_area")
public class PersonnelArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "area_code", nullable = false)
    private String areaCode;

    @Column(name = "area_name", nullable = false)
    private String areaName;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @Column(name = "parent_area_id")
    private Long parentAreaId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "device_count")
    private Integer deviceCount;

    @Column(name = "employee_count")
    private Integer employeeCount;

    // Constructores
    public PersonnelArea() {}

    public PersonnelArea(Long id, String areaCode, String areaName, Boolean isDefault, Long parentAreaId, Long companyId, Integer deviceCount, Integer employeeCount) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PersonnelArea)) {
            return false;
        }
        PersonnelArea other = (PersonnelArea) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.erp.zkteco.entity.PersonnelArea[ id=" + id + " ]";
    }
}
