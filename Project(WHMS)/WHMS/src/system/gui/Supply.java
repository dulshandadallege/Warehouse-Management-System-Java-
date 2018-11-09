/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * 
 */
@Entity
@Table(name = "supply", catalog = "scmdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Supply.findAll", query = "SELECT s FROM Supply s")
    , @NamedQuery(name = "Supply.findByGrnNo", query = "SELECT s FROM Supply s WHERE s.supplyPK.grnNo = :grnNo")
    , @NamedQuery(name = "Supply.findBySplNo", query = "SELECT s FROM Supply s WHERE s.splNo = :splNo")
    , @NamedQuery(name = "Supply.findByMatNo", query = "SELECT s FROM Supply s WHERE s.supplyPK.matNo = :matNo")
    , @NamedQuery(name = "Supply.findByWhNo", query = "SELECT s FROM Supply s WHERE s.whNo = :whNo")
    , @NamedQuery(name = "Supply.findByUnt", query = "SELECT s FROM Supply s WHERE s.unt = :unt")
    , @NamedQuery(name = "Supply.findByUntPrc", query = "SELECT s FROM Supply s WHERE s.untPrc = :untPrc")
    , @NamedQuery(name = "Supply.findByDtTm", query = "SELECT s FROM Supply s WHERE s.dtTm = :dtTm")})
public class Supply implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplyPK supplyPK;
    @Basic(optional = false)
    @Column(name = "splNo")
    private String splNo;
    @Basic(optional = false)
    @Column(name = "whNo")
    private String whNo;
    @Basic(optional = false)
    @Column(name = "unt")
    private double unt;
    @Basic(optional = false)
    @Column(name = "untPrc")
    private double untPrc;
    @Column(name = "dtTm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtTm;

    public Supply() {
    }

    public Supply(SupplyPK supplyPK) {
        this.supplyPK = supplyPK;
    }

    public Supply(SupplyPK supplyPK, String splNo, String whNo, double unt, double untPrc) {
        this.supplyPK = supplyPK;
        this.splNo = splNo;
        this.whNo = whNo;
        this.unt = unt;
        this.untPrc = untPrc;
    }

    public Supply(String grnNo, String matNo) {
        this.supplyPK = new SupplyPK(grnNo, matNo);
    }

    public SupplyPK getSupplyPK() {
        return supplyPK;
    }

    public void setSupplyPK(SupplyPK supplyPK) {
        this.supplyPK = supplyPK;
    }

    public String getSplNo() {
        return splNo;
    }

    public void setSplNo(String splNo) {
        String oldSplNo = this.splNo;
        this.splNo = splNo;
        changeSupport.firePropertyChange("splNo", oldSplNo, splNo);
    }

    public String getWhNo() {
        return whNo;
    }

    public void setWhNo(String whNo) {
        String oldWhNo = this.whNo;
        this.whNo = whNo;
        changeSupport.firePropertyChange("whNo", oldWhNo, whNo);
    }

    public double getUnt() {
        return unt;
    }

    public void setUnt(double unt) {
        double oldUnt = this.unt;
        this.unt = unt;
        changeSupport.firePropertyChange("unt", oldUnt, unt);
    }

    public double getUntPrc() {
        return untPrc;
    }

    public void setUntPrc(double untPrc) {
        double oldUntPrc = this.untPrc;
        this.untPrc = untPrc;
        changeSupport.firePropertyChange("untPrc", oldUntPrc, untPrc);
    }

    public Date getDtTm() {
        return dtTm;
    }

    public void setDtTm(Date dtTm) {
        Date oldDtTm = this.dtTm;
        this.dtTm = dtTm;
        changeSupport.firePropertyChange("dtTm", oldDtTm, dtTm);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplyPK != null ? supplyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supply)) {
            return false;
        }
        Supply other = (Supply) object;
        if ((this.supplyPK == null && other.supplyPK != null) || (this.supplyPK != null && !this.supplyPK.equals(other.supplyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.gui.Supply[ supplyPK=" + supplyPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
