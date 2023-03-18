package com.study.onlinemarket.domain.dto.response;

import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class ManufacturerResponse {
    Long id;
    String name;
    List<ProductInfo> products;

    @Value
    public static class ProductInfo {
        Long id;
        BigDecimal price;
        String name;
        String description;
    }
}
