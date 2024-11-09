package com.erp.restaurante.dto;

public class PermisosRolDto {

    private Integer permisosRolesId;
    private Integer rolId;
    private Integer permisoId;

    // Constructor, Getters, and Setters
    public PermisosRolDto() {}

    public PermisosRolDto(Integer permisosRolesId, Integer rolId, Integer permisoId) {
        this.permisosRolesId = permisosRolesId;
        this.rolId = rolId;
        this.permisoId = permisoId;
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
}
