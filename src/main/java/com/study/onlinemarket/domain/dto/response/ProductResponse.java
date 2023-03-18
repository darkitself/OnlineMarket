package com.study.onlinemarket.domain.dto.response;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductResponse {
    Long id;
    BigDecimal price;
    String name;
    String description;
    ManufacturerInfo manufacturer;

    @Value
    public static class ManufacturerInfo {
        Long id;
        String name;
    }
}
