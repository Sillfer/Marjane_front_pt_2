package com.codesigne.marjanepromo.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Security {
    public static String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    /**
     * check if password is correct
     * @param password String
     * @param hashedPassword String
     */
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
