package com.erp.zkteco.dto;

import java.io.Serializable;

public class PersonnelEmployeeAreaDto implements Serializable {

    private Long id;
    private Long employeeId;
    private Long areaId;

    // Constructor vacío
    public PersonnelEmployeeAreaDto() {}

    // Constructor completo
    public PersonnelEmployeeAreaDto(Long id, Long employeeId, Long areaId) {
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
    public String toString() {
        return "PersonnelEmployeeAreaDto{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", areaId=" + areaId +
                '}';
    }
}
