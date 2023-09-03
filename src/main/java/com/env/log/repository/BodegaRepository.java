package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.env.log.entity.Bodega;


@Repository
public interface BodegaRepository extends CrudRepository<Bodega, Long> {

}
