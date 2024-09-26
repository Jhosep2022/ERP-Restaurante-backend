package com.erp.restaurante.dto;

public class ResponseDto<T> {
    private boolean success;
    private String message;
    private T data;

    // Constructor vacío
    public ResponseDto() {}

    // Constructor con parámetros
    public ResponseDto(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
