package com.study.onlinemarket.service.factory;

import com.study.onlinemarket.adapter.repository.ManufacturerRepository;
import com.study.onlinemarket.common.exception.NotFoundException;
import com.study.onlinemarket.domain.dto.request.CreateProductRequest;
import com.study.onlinemarket.domain.dto.response.ProductResponse;
import com.study.onlinemarket.domain.entity.Manufacturer;
import com.study.onlinemarket.domain.entity.Product;
import com.study.onlinemarket.domain.entity.context.ProductContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductFactory {

    ManufacturerRepository manufacturerRepository;

    public ProductResponse createProductResponseFrom(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getPrice(),
                product.getName(),
                product.getDescription(),
                createManufacturerInfo(product.getManufacturer())
        );
    }

    public ProductContext createProductContextFrom(CreateProductRequest request) {


        //Возможно, ответственность за поиск производителя стоит возложить на сервис
        Manufacturer manufacturer = manufacturerRepository.findById(request.getManufacturerId())
                .orElseThrow(() -> new NotFoundException(
                                String.format("Not found manufacturer with id %d", request.getManufacturerId())
                        )
                );

        return new ProductContext(
                request.getPrice(),
                request.getCount(),
                request.getName(),
                request.getDescription(),
                manufacturer
        );
    }

    private ProductResponse.ManufacturerInfo createManufacturerInfo(Manufacturer manufacturer) {
        return new ProductResponse.ManufacturerInfo(
                manufacturer.getId(),
                manufacturer.getName()
        );
    }
}
