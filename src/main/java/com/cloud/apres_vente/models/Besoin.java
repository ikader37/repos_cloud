/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.apres_vente.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ilboudo
 */
@Entity
@Table(name = "BESOIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besoin.findAll", query = "SELECT b FROM Besoin b")
    , @NamedQuery(name = "Besoin.findByIdBesoin", query = "SELECT b FROM Besoin b WHERE b.idBesoin = :idBesoin")
    , @NamedQuery(name = "Besoin.findByLibelle", query = "SELECT b FROM Besoin b WHERE b.libelle = :libelle")
    , @NamedQuery(name = "Besoin.findByDescription", query = "SELECT b FROM Besoin b WHERE b.description = :description")})
public class Besoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BESOIN")
    private Integer idBesoin;
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "idBesoin")
    private List<ElementDeBesoin> elementDeBesoinList;
    @OneToMany(mappedBy = "idBesoin")
    private List<Service> serviceList;

    public Besoin() {
    }

    public Besoin(Integer idBesoin) {
        this.idBesoin = idBesoin;
    }

    public Integer getIdBesoin() {
        return idBesoin;
    }

    public void setIdBesoin(Integer idBesoin) {
        this.idBesoin = idBesoin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<ElementDeBesoin> getElementDeBesoinList() {
        return elementDeBesoinList;
    }

    public void setElementDeBesoinList(List<ElementDeBesoin> elementDeBesoinList) {
        this.elementDeBesoinList = elementDeBesoinList;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBesoin != null ? idBesoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Besoin)) {
            return false;
        }
        Besoin other = (Besoin) object;
        if ((this.idBesoin == null && other.idBesoin != null) || (this.idBesoin != null && !this.idBesoin.equals(other.idBesoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Besoin[ idBesoin=" + idBesoin + " ]";
    }
    
}
