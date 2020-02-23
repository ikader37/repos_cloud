/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.apres_vente.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ilboudo
 */
@Embeddable
public class RelierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_SERVICE")
    private int idService;
    @Basic(optional = false)
    @Column(name = "ID_BESOIN")
    private int idBesoin;

    public RelierPK() {
    }

    public RelierPK(int idService, int idBesoin) {
        this.idService = idService;
        this.idBesoin = idBesoin;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdBesoin() {
        return idBesoin;
    }

    public void setIdBesoin(int idBesoin) {
        this.idBesoin = idBesoin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idService;
        hash += (int) idBesoin;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelierPK)) {
            return false;
        }
        RelierPK other = (RelierPK) object;
        if (this.idService != other.idService) {
            return false;
        }
        if (this.idBesoin != other.idBesoin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.RelierPK[ idService=" + idService + ", idBesoin=" + idBesoin + " ]";
    }
    
}
