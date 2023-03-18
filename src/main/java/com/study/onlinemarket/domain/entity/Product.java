package com.study.onlinemarket.domain.entity;

import com.study.onlinemarket.adapter.repository.base.BaseDomainEntity;
import com.study.onlinemarket.domain.entity.context.ProductContext;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Product extends BaseDomainEntity<Long> {
    @NonNull
    BigDecimal price;

    @NonNull
    Long count;

    @NonNull
    String name;

    @NonNull
    String description;

    @NonNull
    Manufacturer manufacturer;

    public static Product createProductFrom(ProductContext context) {
        return new Product(
                context.getPrice(),
                context.getCount(),
                context.getName(),
                context.getDescription(),
                context.getManufacturer()
        );
    }
}
