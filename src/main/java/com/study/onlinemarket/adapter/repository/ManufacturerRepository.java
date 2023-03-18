package com.study.onlinemarket.adapter.repository;

import com.study.onlinemarket.adapter.repository.base.BaseStubRepository;
import com.study.onlinemarket.adapter.repository.generator.IdGenerator;
import com.study.onlinemarket.domain.entity.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerRepository extends BaseStubRepository<Manufacturer, Long> {
    public ManufacturerRepository(IdGenerator<Long> idGenerator) {
        super(idGenerator);
    }
}