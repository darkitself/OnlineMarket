package com.study.onlinemarket.service.impl;

import com.study.onlinemarket.adapter.repository.ProductRepository;
import com.study.onlinemarket.domain.dto.request.CreateProductRequest;
import com.study.onlinemarket.domain.dto.response.ProductResponse;
import com.study.onlinemarket.domain.entity.Product;
import com.study.onlinemarket.domain.entity.context.ProductContext;
import com.study.onlinemarket.service.ProductService;
import com.study.onlinemarket.service.factory.ProductFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

    ProductFactory productFactory;
    ProductRepository productRepository;


    @Override
    public List<ProductResponse> getProductsByManufacturer(Long manufacturerId) {
        return productRepository.findAllByManufacturerId(manufacturerId).stream()
                .map(productFactory::createProductResponseFrom)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<ProductResponse> getProductList() {
        return productRepository.findAll().stream()
                .map(productFactory::createProductResponseFrom)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse addNewProduct(CreateProductRequest request) {
        ProductContext context = productFactory.createProductContextFrom(request);
        Product product = Product.createProductFrom(context);
        product = productRepository.save(product);
        return productFactory.createProductResponseFrom(product);
    }
}
