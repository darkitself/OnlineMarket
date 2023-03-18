package com.study.onlinemarket.adapter.repository;

import com.study.onlinemarket.adapter.repository.base.BaseStubRepository;
import com.study.onlinemarket.adapter.repository.generator.IdGenerator;
import com.study.onlinemarket.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository extends BaseStubRepository<Product, Long> {
    public ProductRepository(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }
}
