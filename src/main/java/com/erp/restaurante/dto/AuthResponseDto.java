package com.erp.restaurante.dto;

public class AuthResponseDto {

    private UsuariosDto usuario;
    private String token;

    public AuthResponseDto(UsuariosDto usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public UsuariosDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosDto usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
