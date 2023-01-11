package com.example.utopianstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    //Connecting to the database
    public Statement getStatement(){

        Statement statement = null;
        Connection conn;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/supply_chain","root","12345678");
            statement = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    //It will return the result of the query
    public ResultSet getQueryTable(String query){

        Statement statement = getStatement();
        try{
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Function to insert and update queries to the database
    public int executeUpdateQuery(String query){

        Statement statement = getStatement();
        try{
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
