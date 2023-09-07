package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.env.log.security.entity.UserEntity;



@Repository
public interface UserRepositoryI extends CrudRepository<UserEntity, Long> {

}
