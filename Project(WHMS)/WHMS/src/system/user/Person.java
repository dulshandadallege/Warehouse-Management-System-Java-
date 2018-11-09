/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.awt.Font;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Person Class
 * 
 */
public class Person implements QueryString{
    private String uNm, pw;
    private char prv;
    
    /**
     * 2 parameter constructor
     * @param uNm
     * @param pw 
     */  
    public Person(String uNm, String pw)
    {
        this.uNm=uNm;
        this.pw=pw;
    }

    /**
     * 3 parameter constructor
     * @param uNm
     * @param pw
     * @param prv 
     */
    public Person(String uNm, String pw, char prv) {
        this.uNm = uNm;
        this.pw = pw;
        this.prv = prv;
    }
    
    
    /**
     * Getter
     * get Privilege
     * @return 
     */
    public char getPrv() {
        return prv;
    }

    /**
     * Getter
     * get User Name
     * @return 
     */
    public String getUNm() {
        return uNm;
    }

    /**
     * Setter
     * set Password
     * @param pw 
     */
    public void setPw(String pw) {
        this.pw = pw;
    }
    
    /**
     * Generate Table Model
     * Generates and returns a DefaultTableModel object
     * when a ResultSet is given as an argument.
     * @param rs
     * @return
     * @throws SQLException 
     */
    public static DefaultTableModel generateTableModel(ResultSet rs) throws SQLException
    {
        ResultSetMetaData mtData=null;
        Vector<String> feilds = new Vector<>();
        Vector<Vector<Object>> data= new Vector<Vector<Object>>();
        
        int colCount=0;
        try{
        // input names of the feilds
            mtData = rs.getMetaData();
            colCount=mtData.getColumnCount();
            for (int col = 1; col <= colCount; col++) {
                feilds.add(mtData.getColumnName(col));
            }
  
            // input data to the table
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                
                for (int colIndex = 1; colIndex <= colCount; colIndex++) {
                    vector.add(rs.getObject(colIndex));
                }
                
                data.add(vector);
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return new DefaultTableModel(data, feilds);
    }
    
    /**
     * Updates Person contact details & return true 
     * if update is successful.
     * @param email
     * @param add
     * @param tp
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean updateDetails(String email, String add, String tp) throws SQLException, ClassNotFoundException
    {
        int rows=0;
        
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.PSNUPDTDTLS);
            pstmt.setString(1, email);
            pstmt.setString(2, add);
            pstmt.setString(3, tp);
            pstmt.setString(4, this.uNm);
            rows=pstmt.executeUpdate();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return !(rows==0);
    }
    
    /**
     * Returns all person details as a ResultSet object.
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ResultSet pullDetails() throws SQLException, ClassNotFoundException
    {
        ResultSet rs=null;
        
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.PSNDTLSPULL);
            pstmt.setString(1, this.uNm);
            rs=pstmt.executeQuery();
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        return rs;
    }
    
    /**
     * Overrides current password with the new password
     * which is given as a parameter & returns true if
     * successful.
     * @param psw
     * @return
     * @throws NoSuchAlgorithmException
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean chngPw(String psw) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException
    {
       DBConnection dbCon= new DBConnection();
       Connection con = null;
       PreparedStatement pstmt = null;
       /*Hashing Algorithm MD5*/
       MessageDigest md;
       String hshtxt=null;
       int rows=0;
       
       try{
            md = MessageDigest.getInstance("MD5");
            md.update(psw.getBytes(Charset.forName("UTF-8")),0,psw.length());
            hshtxt = new BigInteger(1,md.digest()).toString(16);
            
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            pstmt=con.prepareStatement(this.CHNGPW);
            
            pstmt.setString(1, hshtxt);
            pstmt.setString(2, this.uNm);
            
            rows=pstmt.executeUpdate();
       }
       catch(NoSuchAlgorithmException | SQLException | ClassNotFoundException ex)
       {
           throw ex;
       }
       finally
       {
            pstmt.close();
            con.close();
       }
       
       return !(rows==0);
    }
        
    /**
     * Compares the login credentials inputted by the user
     * with the database & returns true if they match.
     * @return
     * @throws NoSuchAlgorithmException
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean login() throws NoSuchAlgorithmException, SQLException, ClassNotFoundException
    {   
        final String LOGINQUERY="SELECT * FROM login WHERE psnNo='"+this.uNm+"';";
        Connection con = null;
        DBConnection dbCon= new DBConnection();
        String pwd, hshtxt;
        ResultSet rs=null;
        Statement stmt=null;
        
        try 
        {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt = con.createStatement();
            rs= stmt.executeQuery(LOGINQUERY);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            throw ex;
        }
        
        
        if(!rs.next())
        {
           stmt.close();
           rs.close();
           con.close();
          return false;
        }
        else
        {
            /*Hashing Algorithm MD5*/
            MessageDigest md;
                                  
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                throw ex;
            }
             
            try
            {
                pwd=rs.getString(2);
                this.prv = rs.getString(3).charAt(0);
            
                md.update(pw.getBytes(Charset.forName("UTF-8")),0,this.pw.length());
                hshtxt = new BigInteger(1,md.digest()).toString(16);
            }
            catch(SQLException ex)
            {
                throw ex;
            }
            
            finally
            {
                stmt.close();
                rs.close();
                con.close();
            }
            
            return pwd.equals(hshtxt);
        }
    }
    
    /**
     * view method from the QuerryString interface
     * dummy Implementation
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @Override
    public ResultSet view() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
