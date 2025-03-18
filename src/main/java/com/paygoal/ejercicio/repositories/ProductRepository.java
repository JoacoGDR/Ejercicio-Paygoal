package com.paygoal.ejercicio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paygoal.ejercicio.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findAllByOrderByPriceAsc();
}
