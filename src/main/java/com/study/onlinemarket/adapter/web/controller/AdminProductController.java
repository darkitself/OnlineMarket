package com.study.onlinemarket.adapter.web.controller;

import com.study.onlinemarket.adapter.web.annotation.AdminApiV1;
import com.study.onlinemarket.domain.dto.request.CreateProductRequest;
import com.study.onlinemarket.domain.dto.response.ProductResponse;
import com.study.onlinemarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AdminProductController {

    ProductService productService;

    @PostMapping("/products/add")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest productRequest) {
        return new ResponseEntity<>(productService.addNewProduct(productRequest), HttpStatus.OK);
    }
}
