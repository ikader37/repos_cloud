package com.cloud.apres_vente.dao;
import org.springframework.data.repository.CrudRepository;

import com.cloud.apres_vente.models.Personne;


public interface PersonneDao extends CrudRepository<Personne,Integer>{

}
