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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ilboudo
 */
@Entity
@Table(name = "ELEMENT_DE_BESOIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementDeBesoin.findAll", query = "SELECT e FROM ElementDeBesoin e")
    , @NamedQuery(name = "ElementDeBesoin.findByIdElBesoin", query = "SELECT e FROM ElementDeBesoin e WHERE e.idElBesoin = :idElBesoin")
    , @NamedQuery(name = "ElementDeBesoin.findByLibelle", query = "SELECT e FROM ElementDeBesoin e WHERE e.libelle = :libelle")
    , @NamedQuery(name = "ElementDeBesoin.findByValeur", query = "SELECT e FROM ElementDeBesoin e WHERE e.valeur = :valeur")
    , @NamedQuery(name = "ElementDeBesoin.findByDescription", query = "SELECT e FROM ElementDeBesoin e WHERE e.description = :description")})
public class ElementDeBesoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EL_BESOIN")
    private Integer idElBesoin;
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "VALEUR")
    private String valeur;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToMany(mappedBy = "elementDeBesoinList")
    private List<Demande> demandeList;
    @JoinColumn(name = "ID_BESOIN", referencedColumnName = "ID_BESOIN")
    @ManyToOne
    private Besoin idBesoin;

    public ElementDeBesoin() {
    }

    public ElementDeBesoin(Integer idElBesoin) {
        this.idElBesoin = idElBesoin;
    }

    public Integer getIdElBesoin() {
        return idElBesoin;
    }

    public void setIdElBesoin(Integer idElBesoin) {
        this.idElBesoin = idElBesoin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public Besoin getIdBesoin() {
        return idBesoin;
    }

    public void setIdBesoin(Besoin idBesoin) {
        this.idBesoin = idBesoin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idElBesoin != null ? idElBesoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementDeBesoin)) {
            return false;
        }
        ElementDeBesoin other = (ElementDeBesoin) object;
        if ((this.idElBesoin == null && other.idElBesoin != null) || (this.idElBesoin != null && !this.idElBesoin.equals(other.idElBesoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.ElementDeBesoin[ idElBesoin=" + idElBesoin + " ]";
    }
    
}
