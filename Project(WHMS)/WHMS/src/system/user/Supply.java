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

/**
 * Supply Class
 * 
 */
public class Supply implements QueryString{
    private String grnNo, splNo, matNo, whNo, ut, uPrc, dtTm;
    private double unt, untPrc;
    
    /**
     * 2 parameter constructor
     * @param grnNo
     * @param matNo 
     */
    public Supply(String grnNo, String matNo)
    {
        this.grnNo=grnNo;
        this.matNo=matNo;
    }
    
    /**
     * 6 parameter constructor
     * @param grnNo
     * @param splNo
     * @param matNo
     * @param whNo
     * @param unt
     * @param untPrc 
     */
    public Supply(String grnNo, String splNo, String matNo, String whNo, double unt, double untPrc)
    {
        this.grnNo=grnNo;
        this.splNo=splNo;
        this.matNo=matNo;
        this.whNo=whNo;
        this.unt=unt;
        this.untPrc=untPrc;
    }

    /**
     * 6 parameter constructor
     * @param grnNo
     * @param splNo
     * @param matNo
     * @param whNo
     * @param ut
     * @param uPrc
     * @param dtTm 
     */
    public Supply(String grnNo, String splNo, String matNo, String whNo, String ut, String uPrc, String dtTm) {
        this.grnNo = grnNo;
        this.splNo = splNo;
        this.matNo = matNo;
        this.whNo = whNo;
        this.ut = ut;
        this.uPrc = uPrc;
        this.dtTm=dtTm;
    }
    
    /**
     * Inserts a supply record into the database
     * and returns true if successful.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean insertSupply() throws SQLException, ClassNotFoundException
    {
        int rows=0;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.SPLINST);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        pstmt.setString(1, this.grnNo);
        pstmt.setString(2, this.splNo);
        pstmt.setString(3, this.matNo);
        pstmt.setString(4, this.whNo);
        pstmt.setDouble(5, this.unt);
        pstmt.setDouble(6, this.untPrc);
        
        try{
        rows=pstmt.executeUpdate();
        }
        catch(SQLException ex){
            throw ex;
        }
        
        finally
        {
            pstmt.close();
            con.close();
        }
        
        return rows !=0;      
    }
    
    /**
     * Returns all details of a specific supply record
     * as a ResultSet according to the 
     * GRN number & material number.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet pullSupply() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.SPLPULL2);
            pstmt.setString(1, this.grnNo);
            pstmt.setString(2, this.matNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Updates an existing supply record in the database
     * according to the given GRN number & material number
     * and returns true if successful.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean updateSupply() throws SQLException, ClassNotFoundException
    {
       DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        int rows=0;
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.SPLUPDT);
            pstmt.setDouble(1, this.unt);
            pstmt.setDouble(2, this.untPrc);
            pstmt.setString(3, this.grnNo);
            pstmt.setString(4, this.matNo);
            rows=pstmt.executeUpdate();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        finally
        {
            pstmt.close();
            con.close();
        }
        
        return rows!=0; 
    }
    
    /**
     * Returns all the supply details from the database as a
     * ResultSet according to the applied filters.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException {
        final String SPLVIEW="SELECT * FROM supply WHERE grnNo LIKE "+this.grnNo+" AND splNo LIKE "+this.splNo+
                " AND matNo LIKE "+this.matNo+" AND (whNo"+this.whNo+") AND unt"+this.ut+
                " AND untPrc"+this.uPrc+" AND DATE(dtTm)"+this.dtTm+";";
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        Statement stmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(SPLVIEW);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
}
