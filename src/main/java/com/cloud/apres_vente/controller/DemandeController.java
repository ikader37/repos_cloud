package com.cloud.apres_vente.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.apres_vente.dao.DemandeDao;
import com.cloud.apres_vente.dao.ElementDeBesoinDao;
import com.cloud.apres_vente.dao.PersonneDao;
import com.cloud.apres_vente.dao.ServiceDao;
import com.cloud.apres_vente.models.Demande;
import com.cloud.apres_vente.models.ElementDeBesoin;
import com.cloud.apres_vente.models.Personne;
import com.cloud.apres_vente.models.Service;
import com.cloud.apres_vente.utils.SingletonConnection;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/demande")
public class DemandeController {

	@Autowired
	private DemandeDao demaDao;
	@Autowired
	private ServiceDao serDao;
	@Autowired
	private PersonneDao perDao;
	@Autowired
	private ElementDeBesoinDao elBDao;
	
	Connection cc=SingletonConnection.getConnecter();
	
	/**
	 * Fonction permettant de retourner toutes les demandes enregistrees
	 * @return
	 */
	public List<Demande> listDemande(){
		String sql="select id_demande,libelle,deleted,deleted_at,etat,id_service,date_demande from demande";
		List<Demande> listDem=new ArrayList<>();
		try {
			Statement st=cc.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Demande d=new Demande();
				d.setIdDemande(rs.getInt("id_demande"));
				d.setDateDemande(rs.getDate("date_demande"));
				d.setLibelle(rs.getString("libelle"));
				d.setDeleted(rs.getBoolean("deleted"));
				d.setDeleted_at(rs.getDate("deleted_at"));
				d.setEtat(rs.getString("etat"));
				listDem.add(d);
			}
		}catch(Exception ex) {
				
			}
		return listDem;
	}
	
	@GetMapping("/addDemande")
	@ResponseBody
	public JSONPObject addDemande(@RequestParam(name="idservice") Integer idservice,@RequestParam(name="idpersonne") Integer idpersonne,@RequestParam(name="libelle") String libelle,@RequestParam(name="idelementbesoin") List<Integer> idelements) {
		Demande dema=new Demande();
		dema.setEtat("Debut");
		Service ser=new Service();
		ser.setIdService(idservice);
		Personne p=new Personne();
		p.setIdPersonne(idpersonne);
		
		List<ElementDeBesoin> elementB=new ArrayList<>();
		
		for (Integer idEl : idelements) {
			ElementDeBesoin b=new ElementDeBesoin();
			b.setIdElBesoin(idEl);
			elementB.add(b);
		}
		dema.setLibelle(libelle);
		dema.setDateDemande(new Date());
		dema.setIdService(ser);
		dema.setIdPersonne(p);
		dema.setElementDeBesoinList(elementB);
		
		
		return new JSONPObject("demande", demaDao.save(dema));
	}
	
	@GetMapping("/listDemandeAll")
	@ResponseBody
	public JSONPObject listDemandeAll(){
		String sql="select id_demande,libelle,deleted,deleted_at,etat,id_service,date_demande from demande";
		List<Demande> listDem=new ArrayList<>();
		try {
			Statement st=cc.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Demande d=new Demande();
				d.setIdDemande(rs.getInt("id_demande"));
				d.setDateDemande(rs.getDate("date_demande"));
				d.setLibelle(rs.getString("libelle"));
				d.setDeleted(rs.getBoolean("deleted"));
				d.setDeleted_at(rs.getDate("deleted_at"));
				d.setEtat(rs.getString("etat"));
				listDem.add(d);
			}
		}catch(Exception ex) {
				
			}
		return new JSONPObject("listAllDemande",listDem);
	}
	
	public List<Demande> demandeEtatDebut(){
		return null;
	}
	
	public List<Demande> demandeEncours(){
		return null;
	}
	
	public List<Demande> demandeFini(){
		
		return null;
	}
	
	@GetMapping("/demandeByPersonne")
	@ResponseBody
	public JSONPObject demandeByPersonne(@RequestParam(name="idpersonne") Integer idpersonne){
		System.out.print("ID PER:"+idpersonne);
		Personne personne=new Personne();
		List<Demande> listDem=new ArrayList<>();
		
		String sql="select id_demande,libelle,deleted,deleted_at,etat,id_service,date_demande from demande where id_personne='"+idpersonne+"'";
		try {
			Statement st=cc.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Demande d=new Demande();
				d.setIdDemande(rs.getInt("id_demande"));
				d.setDateDemande(rs.getDate("date_demande"));
				d.setLibelle(rs.getString("libelle"));
				d.setDeleted(rs.getBoolean("deleted"));
				d.setDeleted_at(rs.getDate("deleted_at"));
				d.setEtat(rs.getString("etat"));
				listDem.add(d);
			}
			rs.close();
			st.close();
			
			/*Optional<Personne> p=perDao.findById(idpersonne);
			personne=p.get();
			
			System.out.print("ddd:"+personne.getIdPersonne());
			return new JSONPObject("listDemadePersonne",personne.getDemandeList());
		*/
		} catch (Exception e) {
			/*System.out.println("DDD:"+personne.getIdPersonne());
			// TODO: handle exception
			return null;*/
		}
		
		return new JSONPObject("listDemandePer",listDem);
	}
	
	@GetMapping("/updateDemande")
	public JSONPObject updateDemande(@RequestParam(name="iddemande") Integer iddemande,@RequestParam(name="idservice") Integer idservice,@RequestParam(name="idpersonne") Integer idpersonne,@RequestParam(name="libelle") String libelle,@RequestParam(name="etat") String etat,@RequestParam(name="idelementbesoin",required=false) List<Integer> idelements) {
		Demande dem=new Demande();
		Optional<Demande> optionDemande=demaDao.findById(iddemande);
		Demande dema=new Demande();
		dema=optionDemande.get();
		String sql="update demande set libelle='"+libelle+"' , id_service='"+idservice+"', etat='"+etat+"' where id_demande='"+iddemande+"';";
		//sql+="update demande set id_service='"+idservice+"' where id_demande='"+iddemande+"';";
		//sql+="update demande set etat='"+etat+"' where id_demande='"+iddemande+"';";
		try {
			Statement st=cc.createStatement();
			int i=(int) st.executeLargeUpdate(sql);
			if(i>0) {
				return new JSONPObject("ok",true);
			}else {
				return new JSONPObject("ok",false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERREUR:"+e.getLocalizedMessage());
			return new JSONPObject("ok",false);
		}
		
		/*Service ser=new Service();
		ser.setIdService(idservice);
		Personne p=new Personne();
		p.setIdPersonne(idpersonne);
		
		List<ElementDeBesoin> elementB=new ArrayList<>();
		
		for (Integer idEl : idelements) {
			ElementDeBesoin b=new ElementDeBesoin();
			b.setIdElBesoin(idEl);
			elementB.add(b);
		}
		dema.setLibelle(libelle);
		dema.setDateDemande(new Date());
		dema.setIdService(ser);
		dema.setIdPersonne(p);
		dema.setElementDeBesoinList(elementB);
		
		dema.setIdDemande(iddemande);
		*/
		
		//return demaDao.save(dema);
	}
	
	@GetMapping("/deletedemande")
	@ResponseBody
	public JSONPObject deleteDemande(@RequestParam(name="iddemande") Integer iddemande) {
		Optional<Demande> d;//=new Demande();
		d=demaDao.findById(iddemande);
		
		try {
			String sql="update demande set deleted=1 where id_demande='"+iddemande+"';";
			//sql+=" update demande set";
			Statement st=cc.createStatement();
			int i=st.executeUpdate(sql);
			if(i>0) {
				return new JSONPObject("ok",true);
			}else {
				return new JSONPObject("ok",false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new JSONPObject("ok",false);
		}
		
	}
	
	
	@GetMapping("/listDemandeActuel")
	@ResponseBody
	public JSONPObject demandeActuel(){
		List<Demande> listAl=listDemande();
		List<Demande> demadeNoDel=new ArrayList<>();
		for(Demande d:listAl) {
			if(!d.isDeleted()) {
				demadeNoDel.add(d);
			}
		}
		return new JSONPObject("listDemandeActuel", demadeNoDel);
		
	}
	
	@GetMapping("/listDemandeDel")
	@ResponseBody
	public JSONPObject demandeDeleted(){
		List<Demande> listAl=listDemande();
		List<Demande> demadeDel=new ArrayList<>();
		for(Demande d:listAl) {
			if(d.isDeleted()) {
				System.out.print("ID DEM:"+d.getIdDemande());
				demadeDel.add(d);
			}
		}
		return new JSONPObject("listDemandeDel", demadeDel);
	}
}
