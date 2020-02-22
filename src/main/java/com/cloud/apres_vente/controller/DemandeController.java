package com.cloud.apres_vente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.apres_vente.dao.DemandeDao;
import com.cloud.apres_vente.models.Demande;

@Controller
@RequestMapping("/demande")
public class DemandeController {

	@Autowired
	private DemandeDao demaDao;
	
	
	@GetMapping("/addDemande")
	public Demande addDemande() {
		Demande dema=new Demande();
		
		return demaDao.save(dema);
	}
}
