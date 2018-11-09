/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.test;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import system.user.DBConnection;
import system.user.Person;

/**
 *
 * @author 
 */
public class TestClass {
    public static void main(String[] args) {
        /**
         * Person login
         */
        /*
        Person psn=new Person("SUP00001","123456");
       
        DBConnection dbCon= new DBConnection();
        try {
            Class.forName(dbCon.JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        Connection con = null;
        boolean log = false;
        
        try
        {
          con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW); 
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        try
        {
            log=psn.login(con);
        }
        catch(SQLException | NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }
        
        if(log==true)
            System.out.println("Logged in");
        else
            System.out.println("Invalid Credentials");
            
        */
       
    }
}
