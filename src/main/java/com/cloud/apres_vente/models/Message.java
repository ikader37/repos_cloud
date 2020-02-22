package com.cloud.apres_vente.models;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="MESSAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
	@Id
	@GeneratedValue
	@Column(name="ID_MESSAGE")
	private int idmessage;
	@Column(name="CONTENU")
	private String contenu;
	
	@JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID_PERSONNE")
    @ManyToOne
	private Personne idpersonne;
	private List<Reponse> reponsesList;
	public int getIdmessage() {
		return idmessage;
	}
	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Personne getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Personne idpersonne) {
		this.idpersonne = idpersonne;
	}
	
}
