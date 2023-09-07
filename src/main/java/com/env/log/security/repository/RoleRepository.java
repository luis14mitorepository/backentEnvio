package com.env.log.security.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.env.log.security.entity.RoleEntity;






@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
