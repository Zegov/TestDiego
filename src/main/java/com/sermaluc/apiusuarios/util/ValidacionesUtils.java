package com.sermaluc.apiusuarios.util;

import java.util.regex.Pattern;

public class ValidacionesUtils {

    /// Expresion regular para validar estructura del correo
    private static final String correoREGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    ///  Expresion regular para contraseñas seguras
    private static final String passwordREGEX = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    /// Metodo que valida la estructura del mail
    public static boolean validarCorreo(String correo) {
        return Pattern.compile(correoREGEX).matcher(correo).matches();
    }

    /// Metodo para validar que solo sean numeros
    public static boolean esNumerico(String fono) {
        return fono != null && fono.matches("\\d+");
    }

    /// Metodo que valida la seguridad de la contraseña
    public static boolean validarPassword(String password) {
        return Pattern.compile(passwordREGEX).matcher(password).matches();
    }
}
