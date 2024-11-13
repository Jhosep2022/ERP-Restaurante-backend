package com.erp.restaurante.dto;

public class PermisosRolDto {

    private Integer permisosRolesId;
    private Integer rolId;
    private Integer permisoId;
    private Boolean status; // Nuevo campo booleano de estado

    // Constructor, Getters, and Setters
    public PermisosRolDto() {}

    public PermisosRolDto(Integer permisosRolesId, Integer rolId, Integer permisoId, Boolean status) {
        this.permisosRolesId = permisosRolesId;
        this.rolId = rolId;
        this.permisoId = permisoId;
        this.status = status;
    }

    public Integer getPermisosRolesId() {
        return permisosRolesId;
    }

    public void setPermisosRolesId(Integer permisosRolesId) {
        this.permisosRolesId = permisosRolesId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Integer permisoId) {
        this.permisoId = permisoId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
