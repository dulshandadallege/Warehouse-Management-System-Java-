/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.user;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QueryString Interface
 * 
 */
public interface QueryString {
    public static final String SPLINST="INSERT into supply(grnNo,splNo,matNo,whNo,unt,untPrc) VALUES (?,?,?,?,?,?);";
    public static final String SPLPULL1="SELECT * from supply WHERE grnNo=? AND splNo=? AND matNo=? AND whNo=?;";
    
    public static final String MATPULL="SELECT matNo from sply_mat WHERE splNo=?";
    public static final String SPLPULL="SELECT splNo from sply_mat WHERE matNo=?";
    
    public static final String STKUPDT1="UPDATE stock SET qty=? WHERE whNo=? AND matNo=?;";
    public static final String STKUPDT2="UPDATE stock SET ordLvl=?, maxQty=? WHERE whNo=? AND matNo=?;";
    public static final String STKINST="INSERT into stock values (?,?,?,?,?);";
    public static final String STKPULL1="SELECT * from stock WHERE whNo=? AND matNo=?;";
    public static final String STKPULL2="SELECT * from stock WHERE whNo=?;";
    public static final String STKPULLEX="SELECT SUM(maxQty) FROM stock WHERE whNo=?;";
    
    public static final String WHDTLSPULL="SELECT * from warehouse where whNo=?;";
    public static final String WHMGRPULL="SELECT psnNm, email, tp FROM person WHERE psnNo=(SELECT mgrNo FROM warehouse WHERE whNo=?);";
    
    public static final String PSNDTLSPULL="SELECT * FROM person WHERE psnNo=?;";
    public static final String PSNUPDTDTLS="UPDATE person SET email=?, adr=?, tp=? WHERE psnNo=?;";
    
    public static final String SPLPULL2="SELECT * from supply WHERE grnNo=? AND matNo=?;";
    public static final String SPLUPDT="UPDATE supply SET unt=?, untPrc=?, dtTm=NOW() where grnNo=? AND matNo=?;";
    
    public static final String CHNGPW="UPDATE login SET pw=? WHERE psnNo=?;";
    
    public static final String SUPWHVIEW="SELECT w.whNo, w.strgSpc, w.adr, w.supNo, w.mgrNo, p.psnNm, p.email, p.tp FROM warehouse AS w "
                        + "INNER JOIN person as p ON w.mgrNo=p.psnNo AND w.whNo=?;";
    
    public static final String MGRWHVIEW="SELECT w.whNo, w.strgSpc, w.adr, w.supNo, w.mgrNo, p.psnNm, p.email, p.tp FROM warehouse AS w "
                        + "INNER JOIN person as p ON w.supNo=p.psnNo AND w.whNo=?;";
    
    /**
     * Abstract method 
     * view
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public abstract ResultSet view()throws SQLException, ClassNotFoundException;
    
}
