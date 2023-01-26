package com.example.utopianstore;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class Login {

    //Functions to encrypt input string using SHA-256 encryption
    private byte[] getSHA(String input){

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Function to get encrypted input in form of 16 bit string
    private String getEncryptedPassword(String password){

        String encryptedPassword = null;
        try{
            BigInteger number = new BigInteger(1,getSHA(password));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Function to do login from credentials stores in the table
    public boolean customerLogin(String email, String password){

        String query = String.format("select * from customer where email = '%s' and password = '%s' ",email,getEncryptedPassword(password));

        try{
            DatabaseConnection dbCon = new DatabaseConnection();
            ResultSet rs = dbCon.getQueryTable(query);
            if(rs!=null && rs.next())
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
