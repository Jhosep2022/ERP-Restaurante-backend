package com.erp.restaurante.dto;

public class UpdatePasswordDto {

    private String passwordAntigua;
    private String passwordNueva;

    public String getPasswordAntigua() {
        return passwordAntigua;
    }

    public void setPasswordAntigua(String passwordAntigua) {
        this.passwordAntigua = passwordAntigua;
    }

    public String getPasswordNueva() {
        return passwordNueva;
    }

    public void setPasswordNueva(String passwordNueva) {
        this.passwordNueva = passwordNueva;
    }
}
