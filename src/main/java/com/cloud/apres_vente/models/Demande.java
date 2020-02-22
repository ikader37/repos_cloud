/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.apres_vente.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ilboudo
 */
@Entity
@Table(name = "DEMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")
    , @NamedQuery(name = "Demande.findByIdDemande", query = "SELECT d FROM Demande d WHERE d.idDemande = :idDemande")
    , @NamedQuery(name = "Demande.findByLibelle", query = "SELECT d FROM Demande d WHERE d.libelle = :libelle")
    , @NamedQuery(name = "Demande.findByDateDemande", query = "SELECT d FROM Demande d WHERE d.dateDemande = :dateDemande")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEMANDE")
    private Integer idDemande;
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "DATE_DEMANDE")
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    @JoinTable(name = "FAIRE_DEMANDE", joinColumns = {
        @JoinColumn(name = "ID_DEMANDE", referencedColumnName = "ID_DEMANDE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")})
    @ManyToMany
    private List<Personne> personneList;
    @JoinTable(name = "ELEMENT_BESOIN_DEMANDE", joinColumns = {
        @JoinColumn(name = "ID_DEMANDE", referencedColumnName = "ID_DEMANDE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_EL_BESOIN", referencedColumnName = "ID_EL_BESOIN")})
    @ManyToMany
    private List<ElementDeBesoin> elementDeBesoinList;
    @JoinColumn(name = "ID_SERVICE", referencedColumnName = "ID_SERVICE")
    @ManyToOne
    private Service idService;
    @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")
    @ManyToOne
    private Personne idPersonne;

    public Demande() {
    }

    public Demande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    @XmlTransient
    public List<Personne> getPersonneList() {
        return personneList;
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }

    @XmlTransient
    public List<ElementDeBesoin> getElementDeBesoinList() {
        return elementDeBesoinList;
    }

    public void setElementDeBesoinList(List<ElementDeBesoin> elementDeBesoinList) {
        this.elementDeBesoinList = elementDeBesoinList;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Demande[ idDemande=" + idDemande + " ]";
    }
    
}
