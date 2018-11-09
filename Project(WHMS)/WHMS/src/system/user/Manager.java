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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Manager Class
 * 
 */
public class Manager extends Person{
    
    private List<String> whNo;
    
    /**
     * Single parameter Constructor
     * @param uNm 
     */
    public Manager(String uNm)
    {
        super(uNm,null,'M');
        whNo=null; 
    }
    
    /**
     * Double parameter constructor
     * @param uNm
     * @param pw 
     */
    public Manager(String uNm, String pw) {
        super(uNm, pw,'M');
        whNo=null;
    }
    
    /**
     * Getter
     * get Warehouse number 
     * @return 
     */
    public List<String> getWhNo() {
        return whNo;
    }
    
    /**
     * Set Warehouse Number
     * Selects & inserts the warehouse numbers that
     * belongs to the manager to it's
     * whNo list.
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    
    public void setWhNo() throws SQLException, ClassNotFoundException
    {
        final String QUERYWH="SELECT whNo FROM warehouse WHERE mgrNo='"+this.getUNm()+"';";
        
        ResultSet rs=null;
        DBConnection dbCon= new DBConnection();
        Connection con = null;
        Statement stmt = null;
        whNo=new ArrayList<>();
        
        try {
            Class.forName(dbCon.JDBC_DRIVER);
            con = DriverManager.getConnection(dbCon.DB_URL,dbCon.USR,dbCon.PW);
            stmt=con.createStatement();
            rs=stmt.executeQuery(QUERYWH);
            while(rs.next())
            {
                this.whNo.add(rs.getString("whNo"));
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
