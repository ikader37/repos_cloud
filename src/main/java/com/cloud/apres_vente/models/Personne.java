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
import javax.persistence.ManyToMany;
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
@Table(name = "PERSONNE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
    , @NamedQuery(name = "Personne.findByIdPersonne", query = "SELECT p FROM Personne p WHERE p.idPersonne = :idPersonne")
    , @NamedQuery(name = "Personne.findByIdMessage", query = "SELECT p FROM Personne p WHERE p.idMessage = :idMessage")
    , @NamedQuery(name = "Personne.findByNomPer", query = "SELECT p FROM Personne p WHERE p.nomPer = :nomPer")
    , @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Personne.findByRole", query = "SELECT p FROM Personne p WHERE p.role = :role")
    , @NamedQuery(name = "Personne.findByEmail", query = "SELECT p FROM Personne p WHERE p.email = :email")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONNE")
    private Integer idPersonne;
    @Column(name = "ID_MESSAGE")
    private Integer idMessage;
    @Column(name = "NOM_PER")
    private String nomPer;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "EMAIL")
    private String email;
    @ManyToMany(mappedBy = "personneList")
    private List<Demande> demandeList;
    @OneToMany(mappedBy = "idPersonne")
    private List<Message> messageList;
    @OneToMany(mappedBy = "idPersonne")
    private List<Reponse> reponseList;
    @OneToMany(mappedBy = "idPersonne")
    private List<Demande> demandeList1;

    public Personne() {
    }

    public Personne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getNomPer() {
        return nomPer;
    }

    public void setNomPer(String nomPer) {
        this.nomPer = nomPer;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @XmlTransient
    public List<Reponse> getReponseList() {
        return reponseList;
    }

    public void setReponseList(List<Reponse> reponseList) {
        this.reponseList = reponseList;
    }

    @XmlTransient
    public List<Demande> getDemandeList1() {
        return demandeList1;
    }

    public void setDemandeList1(List<Demande> demandeList1) {
        this.demandeList1 = demandeList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bb.Personne[ idPersonne=" + idPersonne + " ]";
    }
    
}
