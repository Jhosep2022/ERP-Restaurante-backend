package com.erp.zkteco.dto;

import java.io.Serializable;

public class PersonnelDepartmentDto implements Serializable {

    private Long id;
    private String deptCode;
    private String deptName;
    private Boolean isDefault;
    private Long parentDeptId;
    private Long deptManagerId;
    private Long companyId;

    // Constructor vacío
    public PersonnelDepartmentDto() {}

    // Constructor completo
    public PersonnelDepartmentDto(Long id, String deptCode, String deptName, Boolean isDefault, Long parentDeptId, Long deptManagerId, Long companyId) {
        this.id = id;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.isDefault = isDefault;
        this.parentDeptId = parentDeptId;
        this.deptManagerId = deptManagerId;
        this.companyId = companyId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Long getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(Long parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public Long getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Long deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "PersonnelDepartmentDto{" +
                "id=" + id +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", isDefault=" + isDefault +
                ", parentDeptId=" + parentDeptId +
                ", deptManagerId=" + deptManagerId +
                ", companyId=" + companyId +
                '}';
    }
}
