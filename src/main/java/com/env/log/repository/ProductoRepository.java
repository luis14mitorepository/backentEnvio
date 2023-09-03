package com.env.log.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.env.log.entity.Producto;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
