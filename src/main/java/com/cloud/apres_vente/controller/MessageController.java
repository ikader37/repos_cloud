package com.cloud.apres_vente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.apres_vente.dao.MessageDao;
import com.cloud.apres_vente.models.Message;
import com.cloud.apres_vente.models.Personne;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageDao msgeDao;
	
	
	//@PostMapping("/addmsge")
	@GetMapping("/addmsge")
	@ResponseBody
	public Message addMessage(@RequestParam(name="contenu",required=true) String contenu,@RequestParam(name="idpersonne",required=true) Integer idpersonne) {
		Message msge=new Message();
		msge.setContenu(contenu);
		Personne p=new Personne();
		p.setIdPersonne(idpersonne);
		msge.setIdPersonne(p);
		
		boolean b=false;//msgeDao.addMessage(msge);
		return msgeDao.save(msge);
	}
	@GetMapping("/list")
	public List<Message> messageListAll(){
		
	
		return (List<Message>) msgeDao.findAll();
	}
	
	@GetMapping("/myMessage")
	public List<Message> myMessage(@RequestParam(name="idpersonne") Integer idpersonne){
		Optional<Personne> opPersonne;//=
		return null;
	}
	
}
