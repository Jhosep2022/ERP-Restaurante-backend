package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnel_employee_area")
public class PersonnelEmployeeArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "area_id", nullable = false)
    private Long areaId;

    // Constructor vacío
    public PersonnelEmployeeArea() {}

    // Constructor completo
    public PersonnelEmployeeArea(Long id, Long employeeId, Long areaId) {
        this.id = id;
        this.employeeId = employeeId;
        this.areaId = areaId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PersonnelEmployeeArea)) {
            return false;
        }
        PersonnelEmployeeArea other = (PersonnelEmployeeArea) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.erp.zkteco.entity.PersonnelEmployeeArea[ id=" + id + " ]";
    }
}
