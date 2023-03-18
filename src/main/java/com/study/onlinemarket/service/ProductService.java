package com.study.onlinemarket.service;

import com.study.onlinemarket.domain.dto.request.CreateProductRequest;
import com.study.onlinemarket.domain.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProductsByManufacturer(Long manufacturerId);

    List<ProductResponse> getProductList();

    ProductResponse addNewProduct(CreateProductRequest request);
}
