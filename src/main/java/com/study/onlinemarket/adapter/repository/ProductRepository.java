package com.study.onlinemarket.adapter.repository;

import com.study.onlinemarket.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByManufacturerId(Long manufacturer_id);
}
