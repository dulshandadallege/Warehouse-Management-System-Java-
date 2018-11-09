/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Supervisor Class
 *
 */
public class Supervisor extends Person{
    
    private String whNo;
    
    /**
     * 1 parameter constructor
     * @param uNm 
     */
    public Supervisor(String uNm)
    {
        super(uNm,null,'S');
        whNo=null;
    }
    
    /**
     * 2 parameter constructor
     * @param uNm
     * @param pw 
     */
    public Supervisor(String uNm, String pw) {
        super(uNm, pw,'S');
        whNo=null;
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
     * Set the supervisors warehouse number by retrieving
     * it from the database.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public void setWhNo() throws SQLException, ClassNotFoundException
    {
        final String QUERYWH="SELECT whNo FROM warehouse WHERE supNo='"+this.getUNm()+"';";
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        ResultSet rs=null;
        Statement stmt = null;
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(QUERYWH);
            if(rs.next()){
                this.whNo=rs.getString(1);
            }
        } 
        catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
        
        finally
        {
            rs.close();
            stmt.close();
            con.close();
        }
    }
}
