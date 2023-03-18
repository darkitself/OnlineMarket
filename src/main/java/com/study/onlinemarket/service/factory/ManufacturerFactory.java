package com.study.onlinemarket.service.factory;

import com.study.onlinemarket.domain.dto.request.CreateManufacturerRequest;
import com.study.onlinemarket.domain.dto.response.ManufacturerResponse;
import com.study.onlinemarket.domain.entity.Manufacturer;
import com.study.onlinemarket.domain.entity.Product;
import com.study.onlinemarket.domain.entity.context.ManufacturerContext;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ManufacturerFactory {
    public ManufacturerResponse createManufacturerResponseFrom(Manufacturer manufacturer) {
        return new ManufacturerResponse(
                manufacturer.getId(),
                manufacturer.getName(),
                manufacturer.getProducts().stream()
                        .map(this::createProductInfo)
                        .collect(Collectors.toList())
        );
    }

    public ManufacturerContext createManufacturerContextFrom(CreateManufacturerRequest request) {
        return new ManufacturerContext(
                request.getName()
        );
    }

    private ManufacturerResponse.ProductInfo createProductInfo(Product product) {
        return new ManufacturerResponse.ProductInfo(
                product.getId(),
                product.getPrice(),
                product.getName(),
                product.getDescription()
        );
    }
}
