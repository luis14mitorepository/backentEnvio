package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.env.log.entity.EnvioCamiones;



@Repository
public interface EnvioCamionesRepository extends CrudRepository<EnvioCamiones, Long> {

}
