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

/**
 * Stock Class
 * 
 */
public class Stock implements QueryString{
    private String whNo, matNo, qt, oLvl, mQty;
    private double qty, ordLvl, maxQty;

    /**
     * 5 parameter constructor
     * @param whNo
     * @param matNo
     * @param qty
     * @param ordLvl
     * @param maxQty 
     */
    public Stock(String whNo, String matNo, double qty, double ordLvl, double maxQty) {
        this.whNo = whNo;
        this.matNo = matNo;
        this.qty = qty;
        this.ordLvl = ordLvl;
        this.maxQty = maxQty;
    }

    /**
     * 5 parameter constructor
     * @param whNo
     * @param matNo
     * @param qt
     * @param oLvl
     * @param mQty 
     */
    public Stock(String whNo, String matNo, String qt, String oLvl, String mQty) {
        this.whNo = whNo;
        this.matNo = matNo;
        this.qt = qt;
        this.oLvl = oLvl;
        this.mQty = mQty;
    }
    
    /**
     * 2 parameter constructor
     * @param whNo
     * @param matNo 
     */
    public Stock(String whNo, String matNo)
    {
        this.whNo=whNo;
        this.matNo=matNo;
    }
    
    /**
     * 1 parameter constructor 
     * @param whNo 
     */
    public Stock(String whNo)
    {
        this.whNo=whNo;
    }
    
    /**
     * Updates the order level and the maximum 
     * quantity of the current Stock record
     * & returns true if successful.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean updateStock()throws SQLException, ClassNotFoundException
    {
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        int rows=0;
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKUPDT2);
            pstmt.setDouble(1, this.ordLvl);
            pstmt.setDouble(2, this.maxQty);
            pstmt.setString(3, this.whNo);
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
     * Updates the Quantity of the current stock
     * & returns true if successful.
     * @param qty
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean upateStock(double qty) throws SQLException, ClassNotFoundException
    {
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        int rows=0;
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKUPDT1);
            pstmt.setDouble(1, qty);
            pstmt.setString(2, this.whNo);
            pstmt.setString(3, this.matNo);
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
     * Insert a new stock into the database and
     * returns true if successful.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean insertStock() throws SQLException, ClassNotFoundException
    {
        int rows=0;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKINST);
            pstmt.setString(1, this.whNo);
            pstmt.setString(2, this.matNo);
            pstmt.setDouble(3, this.qty);
            pstmt.setDouble(4, this.ordLvl);
            pstmt.setDouble(5, this.maxQty);
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
        
        return rows !=0;      
    }
    
    /**
     * Pull Existing Stock
     * Returns the sum of the maximum stock levels of each
     * material in the current warehouse.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public double pullExStock() throws SQLException, ClassNotFoundException
    {
        double exStk=0;
        
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKPULLEX);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
            
            if(rs.next())
            {
                exStk=rs.getDouble(1);
            }
            
            return exStk;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        finally
        {
            pstmt.close();
            rs.close();
            con.close();
        }
    }
    
    
    /**
     * Returns all the stock details of the current
     * warehouse as a ResultSet.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet pullStock() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKPULL2);
            pstmt.setString(1, this.whNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Returns relevant records including all 
     * stock details as a ResultSet when 
     * warehouse number and material number 
     * are given as arguments.
     * @param whNo
     * @param matNo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet pullStock(String whNo, String matNo) throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.STKPULL1);
            pstmt.setString(1, whNo);
            pstmt.setString(2,matNo);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Check whether a given stock is available
     * in a given warehouse & returns true if found.
     * @param whNo
     * @param matNo
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static boolean isAvailable(String whNo, String matNo) throws SQLException, ClassNotFoundException
    {
        final String STKPULL1="SELECT * from stock WHERE whNo=? AND matNo=?;";
        
        ResultSet rs=null;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(STKPULL1);
            
            pstmt.setString(1,whNo);
            pstmt.setString(2,matNo);
            rs=pstmt.executeQuery();
            return rs.next();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    /**
     * Filters records from stock according to
     * the given parameters & returns the results as
     * a ResultSet.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException {
         final String STKVIEW="SELECT * FROM stock WHERE whNo='"+this.whNo+"' AND matNo LIKE "+this.matNo+" AND "
                + "qty"+this.qt+ " AND ordLvl"+this.oLvl+" AND maxQty"+this.mQty+";";
        
        ResultSet rs=null; 
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        Statement stmt=null;
                
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(STKVIEW);
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    
}
