package com.cloud.apres_vente.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Service {

	private int idservice;
	private String libelle;
	private String description;
	private List<Demande> demandeList;
	
}
