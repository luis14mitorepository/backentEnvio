package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.env.log.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
