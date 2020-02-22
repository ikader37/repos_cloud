package com.cloud.apres_vente.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import com.cloud.apres_vente.utils.SingletonConnection;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageDao msgeDao;
	Connection cc=SingletonConnection.getConnecter();
	
	public List<Message> listMessage(String sql){
		List<Message> listMessage=new ArrayList<>();
		
		try {
			Statement st=cc.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				Message m=new Message();
				m.setIdMessage(rs.getInt(1));
				m.setContenu(rs.getString(2));
				listMessage.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listMessage;
	}
	
	private boolean requestUpdate(String sql) {
		try {
			Statement st=cc.createStatement();
		    int i=st.executeUpdate(sql);
		    if(i>0) {
		    	return true;
		    }else {
		    	return false;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur :"+e.getLocalizedMessage());
			return false;
		}
		
	}
	
	
	
	@GetMapping("/addmsge")
	@ResponseBody
	public JSONPObject addMessage(@RequestParam(name="contenu",required=true) String contenu,@RequestParam(name="idpersonne",required=true) Integer idpersonne) {
		Message msge=new Message();
		msge.setContenu(contenu);
		try {
			String sql="insert into message(id_personne,contenu) values(?,?)";
			PreparedStatement st=cc.prepareStatement(sql);
			st.setInt(1, idpersonne);
			st.setString(2, contenu);
			int i=st.executeUpdate();
			if(i>0) {
				return new JSONPObject("ok",true);
			}else {
				return new JSONPObject("ok",false);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Message:"+e.getLocalizedMessage());
			return new JSONPObject("ok",false);
		}
		
	}
	@RequestMapping("/list")
	@ResponseBody
	public JSONPObject messageListAll(){
		
		String sql="select id_message,contenu from message";
		List<Message> l=listMessage(sql);
		return new JSONPObject("listMsge",l);
	}
	
	@GetMapping("/listPersonne")
	@ResponseBody
	public JSONPObject messageListPersonne(@RequestParam(name="idpersonne") Integer idpersonne){
		
		String sql="select id_message,contenu from message where id_personne='"+idpersonne+"'";
		List<Message> l=listMessage(sql);
		return new JSONPObject("listMsge",l);
	}
	
	@GetMapping("/myMessage")
	public List<Message> myMessage(@RequestParam(name="idpersonne") Integer idpersonne){
	//	Optional<Personne> opPersonne;//=
		return null;
	}
	
	@RequestMapping("/updateMsge")
	public JSONPObject updateMessage(@RequestParam(name="contenu") String contenu,@RequestParam(name="idmessage") Integer idmessage) {
		String sql="update message set contenu='"+contenu+"' where id_message='"+idmessage+"'";
		boolean b=requestUpdate(sql);
		if(b) {
			return new JSONPObject("ok",true);
		}else {
			return new JSONPObject("ok",false);
		}
		//return null;
	}
}
