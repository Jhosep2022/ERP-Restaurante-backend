package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnel_position")
public class PersonnelPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "position_code", nullable = false)
    private String positionCode;

    @Column(name = "position_name", nullable = false)
    private String positionName;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault;

    @Column(name = "parent_position_id")
    private Long parentPositionId;

    @Column(name = "company_id")
    private Long companyId;

    // Constructores
    public PersonnelPosition() {}

    public PersonnelPosition(Long id, String positionCode, String positionName, Boolean isDefault, Long parentPositionId, Long companyId) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PersonnelPosition)) {
            return false;
        }
        PersonnelPosition other = (PersonnelPosition) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.erp.zkteco.entity.PersonnelPosition[ id=" + id + " ]";
    }
}
