/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Warehouse Class
 * 
 */
public class Warehouse implements QueryString{
    private String whNo, supNo, mgrNo;
    private double strgSpc;

    /**
     * 1 parameter constructor
     * @param whNo 
     */
    public Warehouse(String whNo)
    {
        this.whNo=whNo;
    }
    
    /**
     * Getter
     * get warehouse number
     * @return 
     */
    public String getWhNo() {
        return whNo;
    }

    /**
     * Getter
     * get the total storage space 
     * of the warehouse.
     * @return 
     */
    public double getStrgSpc() {
        return strgSpc;
    }
    
    /**
     * Returns the manager details of the current 
     * warehouse as a ResultSet.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet pullManager() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.WHMGRPULL);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        return rs;
    }
    
    /**
     * Queries and applies all warehouse details of
     * the current warehouse to their respective
     * instance variables.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void pullWhDtls() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.WHDTLSPULL);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                this.strgSpc=rs.getDouble(2);
                this.supNo=rs.getString(4);
                this.mgrNo=rs.getString(5);
            }
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        finally
        {
            rs.close();
            pstmt.close();
            con.close();
        }
    }
    
    /**
     * Returns all the details of the assigned 
     * warehouse as a ResultSet for a
     * supervisor according to the filters applied.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException {
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(SUPWHVIEW);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Returns all the details of the selected warehouse 
     * from the assigned warehouses as a ResultSet 
     * for a manager according to the filers applied.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet viewAsManager() throws SQLException, ClassNotFoundException {
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(MGRWHVIEW);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
}
