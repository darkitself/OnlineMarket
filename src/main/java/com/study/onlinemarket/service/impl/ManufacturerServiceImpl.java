package com.study.onlinemarket.service.impl;

import com.study.onlinemarket.adapter.repository.ManufacturerRepository;
import com.study.onlinemarket.domain.dto.request.CreateManufacturerRequest;
import com.study.onlinemarket.domain.dto.response.ManufacturerResponse;
import com.study.onlinemarket.domain.entity.Manufacturer;
import com.study.onlinemarket.domain.entity.context.ManufacturerContext;
import com.study.onlinemarket.service.ManufacturerService;
import com.study.onlinemarket.service.factory.ManufacturerFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerFactory manufacturerFactory;
    ManufacturerRepository manufacturerRepository;

    @Override
    public List<ManufacturerResponse> getManufacturers() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturerFactory::createManufacturerResponseFrom)
                .collect(Collectors.toList());
    }

    @Override
    public ManufacturerResponse addNewManufacturer(CreateManufacturerRequest request) {
        ManufacturerContext context = manufacturerFactory.createManufacturerContextFrom(request);
        Manufacturer manufacturer = Manufacturer.createManufacturerFrom(context);
        manufacturer = manufacturerRepository.save(manufacturer);
        return manufacturerFactory.createManufacturerResponseFrom(manufacturer);
    }
}
