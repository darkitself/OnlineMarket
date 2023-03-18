package com.study.onlinemarket.domain.dto.request;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateProductRequest {
    BigDecimal price;

    Long count;

    String name;

    String description;

    Long manufacturerId;
}
