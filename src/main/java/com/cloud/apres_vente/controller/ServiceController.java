package com.cloud.apres_vente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServiceController {

	@PostMapping("/addService")
	public String addService(@RequestParam(name="libelle",required=true) String libelle,Model model) {
		
		
		return "";
	}
}
