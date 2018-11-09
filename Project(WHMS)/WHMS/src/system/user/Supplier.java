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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Supplier Class
 * 
 */
public class Supplier implements QueryString{
    private String splNo, splNm, adr, email, tp;
    
    /**
     * 1 parameter constructor
     * @param supNo 
     */
    public Supplier(String supNo)
    {
        this.splNo=supNo;
    }
    
    /**
     * 5 parameter constructor
     * @param splNo
     * @param splNm
     * @param adr
     * @param email
     * @param tp 
     */
    public Supplier(String splNo, String splNm, String adr, String email, String tp) {
        this.splNo = splNo;
        this.splNm = splNm;
        this.adr = adr;
        this.email = email;
        this.tp = tp;
    }
    
    /**
     * Returns a list of supplier numbers of
     * all suppliers in the database.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static List<String> listSuppliers() throws SQLException, ClassNotFoundException
    {
        final String SUPPULL="SELECT splNo from supplier;"; 
        List<String> sup=new ArrayList<>();
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(SUPPULL);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                sup.add(rs.getString(1));
            }
        
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return sup;
    }
    
    /**
     * Returns a list of materials that 
     * the current supplier can supply.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public List<String> listMaterials() throws SQLException, ClassNotFoundException
    {
        List<String> mat=new ArrayList<>();
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.MATPULL);
            pstmt.setString(1, this.splNo);
            rs=pstmt.executeQuery();
             while(rs.next())
            {
                mat.add(rs.getString(1));
            }
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
       
        return mat;
    }
    
    /**
     * Returns all the details of suppliers according
     * to the applied filters.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException
    {
        final String SUPVIEW="SELECT * FROM supplier WHERE splNo LIKE "+this.splNo+" AND splNm LIKE "+this.splNm+" AND "
                + "adr LIKE "+this.adr+" AND email LIKE "+this.email+" AND tp LIKE "+this.tp+";";
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        Statement stmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(SUPVIEW);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
}
