package com.cloud.apres_vente.dao;
import org.springframework.data.repository.CrudRepository;

import com.cloud.apres_vente.models.Service;
public interface ServiceDao extends CrudRepository<Service,Integer>{

}
