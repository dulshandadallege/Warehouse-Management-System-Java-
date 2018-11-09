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
 * Material Class
 * 
 */
public class Material implements QueryString{
    private String matNo, matNm, des;
    
    /**
     * 1 Parameter Constructor
     * @param matNo 
     */
    public Material(String matNo) {
        this.matNo = matNo;
    }

    /**
     * 3 Parameter Constructor
     * @param matNo
     * @param matNm
     * @param des 
     */
    public Material(String matNo, String matNm, String des) {
        this.matNo = matNo;
        this.matNm = matNm;
        this.des = des;
    }
    
    
    /**
     * Returns a list of all material
     * numbers in the database.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static List<String> listMaterial() throws SQLException, ClassNotFoundException
    {
        List<String> mat=new ArrayList<>();
        final String MATPULL1="SELECT matNo FROM material;";
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(MATPULL1);
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
     * Selects all material details from the
     * database according to the filters given.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException {
        final String MATVIEW="SELECT * FROM material WHERE matNo LIKE "+this.matNo+" AND matNm LIKE "+this.matNm+" AND "
                + "des LIKE "+this.des+";";
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        Statement stmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(MATVIEW);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Returns a list of supplier's numbers who
     * can supply the current item. 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public List<String> listSuppliers() throws SQLException, ClassNotFoundException
    {
        List<String> spl=new ArrayList<>();
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.SPLPULL);
            pstmt.setString(1, this.matNo);
            rs=pstmt.executeQuery();
             while(rs.next())
            {
                spl.add(rs.getString(1));
            } 
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
       
        return spl;
    }
}
