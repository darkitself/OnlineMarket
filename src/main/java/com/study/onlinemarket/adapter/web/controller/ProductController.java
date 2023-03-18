package com.study.onlinemarket.adapter.web.controller;

import com.study.onlinemarket.adapter.web.annotation.ApiV1;
import com.study.onlinemarket.domain.dto.response.ProductResponse;
import com.study.onlinemarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@ApiV1
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @GetMapping("/products/list")
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

    @GetMapping("/products/list/{manufacturerId}")
    public ResponseEntity<List<ProductResponse>> getProductsByManufacturer(@PathVariable Long manufacturerId) {
        return new ResponseEntity<>(productService.getProductsByManufacturer(manufacturerId), HttpStatus.OK);
    }
}
