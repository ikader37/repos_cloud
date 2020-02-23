/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.apres_vente.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ilboudo
 */
@Entity
@Table(name = "RELIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relier.findAll", query = "SELECT r FROM Relier r")
    , @NamedQuery(name = "Relier.findByIdService", query = "SELECT r FROM Relier r WHERE r.relierPK.idService = :idService")
    , @NamedQuery(name = "Relier.findByIdBesoin", query = "SELECT r FROM Relier r WHERE r.relierPK.idBesoin = :idBesoin")})
public class Relier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelierPK relierPK;

    public Relier() {
    }

    public Relier(RelierPK relierPK) {
        this.relierPK = relierPK;
    }

    public Relier(int idService, int idBesoin) {
        this.relierPK = new RelierPK(idService, idBesoin);
    }

    public RelierPK getRelierPK() {
        return relierPK;
    }

    public void setRelierPK(RelierPK relierPK) {
        this.relierPK = relierPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relierPK != null ? relierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relier)) {
            return false;
        }
        Relier other = (Relier) object;
        if ((this.relierPK == null && other.relierPK != null) || (this.relierPK != null && !this.relierPK.equals(other.relierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Relier[ relierPK=" + relierPK + " ]";
    }
    
}
