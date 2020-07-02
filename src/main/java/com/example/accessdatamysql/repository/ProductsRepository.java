package com.example.accessdatamysql.repository;

import com.example.accessdatamysql.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    List<Products> findByName(String name);

}
