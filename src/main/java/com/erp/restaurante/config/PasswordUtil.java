package com.erp.restaurante.config;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Método para encriptar la contraseña
    public static String encryptPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Método para verificar la contraseña
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
