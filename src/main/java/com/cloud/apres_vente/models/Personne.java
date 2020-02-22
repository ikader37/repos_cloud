package com.cloud.apres_vente.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Entity
@Table(name="PERSONNE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Personne {

	@Id
	@Column(name="ID_PERSONNE")
	@GeneratedValue
	private int idpersonne;
	@OneToMany(mappedBy = "idpersonne")
	private List<Message> messageList;
	
	public int getIdpersonne() {
		return idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	@XmlTransient
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	
}
