package com.cloud.apres_vente.dao;
import org.springframework.data.repository.CrudRepository;

import com.cloud.apres_vente.models.Demande;
public interface DemandeDao extends CrudRepository<Demande,Integer>{

}
