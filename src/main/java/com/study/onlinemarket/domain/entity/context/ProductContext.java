package com.study.onlinemarket.domain.entity.context;

import com.study.onlinemarket.domain.entity.Manufacturer;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductContext {

    BigDecimal price;

    Long count;

    String name;

    String description;

    Manufacturer manufacturer;
}
