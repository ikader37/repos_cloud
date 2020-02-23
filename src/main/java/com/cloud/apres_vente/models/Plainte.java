/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloud.apres_vente.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ilboudo
 */
@Entity
@Table(name = "PLAINTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plainte.findAll", query = "SELECT p FROM Plainte p")
    , @NamedQuery(name = "Plainte.findByIdPlainte", query = "SELECT p FROM Plainte p WHERE p.idPlainte = :idPlainte")
    , @NamedQuery(name = "Plainte.findByContenu", query = "SELECT p FROM Plainte p WHERE p.contenu = :contenu")})
public class Plainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PLAINTE")
    private Integer idPlainte;
    @Column(name = "CONTENU")
    private String contenu;
    @JoinColumn(name = "ID_SERVICE", referencedColumnName = "ID_SERVICE")
    @ManyToOne
    private Service idService;

    public Plainte() {
    }

    public Plainte(Integer idPlainte) {
        this.idPlainte = idPlainte;
    }

    public Integer getIdPlainte() {
        return idPlainte;
    }

    public void setIdPlainte(Integer idPlainte) {
        this.idPlainte = idPlainte;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlainte != null ? idPlainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plainte)) {
            return false;
        }
        Plainte other = (Plainte) object;
        if ((this.idPlainte == null && other.idPlainte != null) || (this.idPlainte != null && !this.idPlainte.equals(other.idPlainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Plainte[ idPlainte=" + idPlainte + " ]";
    }
    
}
