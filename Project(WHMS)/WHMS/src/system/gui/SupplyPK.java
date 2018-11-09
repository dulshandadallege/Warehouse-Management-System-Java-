/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.gui;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * 
 */
@Embeddable
public class SupplyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "grnNo")
    private String grnNo;
    @Basic(optional = false)
    @Column(name = "matNo")
    private String matNo;

    public SupplyPK() {
    }

    public SupplyPK(String grnNo, String matNo) {
        this.grnNo = grnNo;
        this.matNo = matNo;
    }

    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    public String getMatNo() {
        return matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grnNo != null ? grnNo.hashCode() : 0);
        hash += (matNo != null ? matNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplyPK)) {
            return false;
        }
        SupplyPK other = (SupplyPK) object;
        if ((this.grnNo == null && other.grnNo != null) || (this.grnNo != null && !this.grnNo.equals(other.grnNo))) {
            return false;
        }
        if ((this.matNo == null && other.matNo != null) || (this.matNo != null && !this.matNo.equals(other.matNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.gui.SupplyPK[ grnNo=" + grnNo + ", matNo=" + matNo + " ]";
    }
    
}
