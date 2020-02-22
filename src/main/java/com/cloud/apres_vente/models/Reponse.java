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
@Table(name = "REPONSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reponse.findAll", query = "SELECT r FROM Reponse r")
    , @NamedQuery(name = "Reponse.findByIdReponse", query = "SELECT r FROM Reponse r WHERE r.idReponse = :idReponse")
    , @NamedQuery(name = "Reponse.findByContenu", query = "SELECT r FROM Reponse r WHERE r.contenu = :contenu")})
public class Reponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REPONSE")
    private Integer idReponse;
    @Column(name = "CONTENU")
    private String contenu;
    @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")
    @ManyToOne
    private Personne idPersonne;
    @JoinColumn(name = "ID_MESSAGE", referencedColumnName = "ID_MESSAGE")
    @ManyToOne
    private Message idMessage;

    public Reponse() {
    }

    public Reponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReponse != null ? idReponse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reponse)) {
            return false;
        }
        Reponse other = (Reponse) object;
        if ((this.idReponse == null && other.idReponse != null) || (this.idReponse != null && !this.idReponse.equals(other.idReponse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Reponse[ idReponse=" + idReponse + " ]";
    }
    
}
