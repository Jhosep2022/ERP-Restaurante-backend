package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnel_department")
public class PersonnelDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_code", nullable = false)
    private String deptCode;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @Column(name = "parent_dept_id")
    private Long parentDeptId;

    @Column(name = "dept_manager_id")
    private Long deptManagerId;

    @Column(name = "company_id")
    private Long companyId;

    // Constructores
    public PersonnelDepartment() {}

    public PersonnelDepartment(Long id, String deptCode, String deptName, Boolean isDefault, Long parentDeptId, Long deptManagerId, Long companyId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PersonnelDepartment)) {
            return false;
        }
        PersonnelDepartment other = (PersonnelDepartment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.erp.zkteco.entity.PersonnelDepartment[ id=" + id + " ]";
    }
}
