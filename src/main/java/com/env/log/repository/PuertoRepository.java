package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.env.log.entity.Puerto;


@Repository
public interface PuertoRepository extends CrudRepository<Puerto, Long> {

}
