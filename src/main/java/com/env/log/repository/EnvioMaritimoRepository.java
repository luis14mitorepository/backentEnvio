package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.env.log.entity.EnvioMaritimo;


@Repository
public interface EnvioMaritimoRepository extends CrudRepository<EnvioMaritimo, Long> {

}

