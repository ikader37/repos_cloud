package com.cloud.apres_vente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.apres_vente.dao.PersonneDao;
import com.cloud.apres_vente.dao.ServiceDao;
import com.cloud.apres_vente.models.Personne;
import com.cloud.apres_vente.models.Service;

@RestController
public class ServiceController {
	
	@Autowired
	ServiceDao serDao;
	PersonneDao perDao;

	@PostMapping("/addService")
	public Service addService(@RequestParam(name="libelle",required=true) String libelle,@RequestParam(name="contenu") String desc) {
		Service ser=new Service();
		ser.setLibelle(libelle);
		ser.setDescription(desc);
		return serDao.save(ser);
		
	}
	
	@GetMapping("/listAllService")
	public List<Service> listAllService(){
		return (List<Service>) serDao.findAll();
	}
	
	
}
