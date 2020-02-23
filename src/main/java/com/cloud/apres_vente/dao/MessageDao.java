package com.cloud.apres_vente.dao;
import com.cloud.apres_vente.models.*;
import com.cloud.apres_vente.utils.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageDao extends CrudRepository<Message,Integer>{
	Connection cc=SingletonConnection.getConnecter();
	/*public boolean addMessage(Message msg) {
		boolean b=false;
		try {
			String sql="insert into message (ID_MESSAGE,CONTENU,ID_PERSONNE) values(?,?,?)";
			PreparedStatement pst=cc.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, msg.getContenu());
			pst.setInt(3, msg.getIdpersonne().getIdpersonne());
			
			
			int ex=pst.executeUpdate();
			if(ex>0) {
				b=true;
			}else {
				b=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return b;
	}
	
	
	public List<Message> listToutMessage(){
		return null;
	}
	public List<Message> mesMessage(Personne personne){
		
		return null;
	}
	*/
	

}
