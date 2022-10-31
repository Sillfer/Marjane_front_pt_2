package com.codesigne.marjanepromo.helpers;


import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class HashPassword {
    static Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id,32,64);


    //heshing password
    public static String getHashedPassword(String password){
        return argon2.hash(2,15*1024,1,password.toCharArray());
    }

    //compare hash password with Normal password
    public static Boolean verifiedPassword(String HashPAssword,String password){
        return argon2.verify(HashPAssword,password.toCharArray());
    }


}
