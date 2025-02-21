package org.example;

public class StringUtils {

    // Méthode qui retourne une chaîne de caractères inversée
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

//  Méthode qui retourne une chaîne de caractères avec la première lettre en majuscule
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
