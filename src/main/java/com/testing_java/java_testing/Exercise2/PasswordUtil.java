package com.testing_java.java_testing.Exercise2;

public class PasswordUtil {
    public enum SecurityLevel{
        WEAK, MEDIUM, STRONG
    }

    // Funcion para devolver el nivel de seguridad de la password
    public static SecurityLevel assessPassword(String password){
        if(password.length()<8){
            return SecurityLevel.WEAK;
        }

        // Enviando expresion regular
        if(password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
