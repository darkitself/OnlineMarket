package com.study.onlinemarket.domain.entity;

import com.study.onlinemarket.adapter.repository.base.BaseDomainEntity;
import com.study.onlinemarket.domain.entity.context.ManufacturerContext;
import lombok.NonNull;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

@Value
public class Manufacturer extends BaseDomainEntity<Long> {
    @NonNull
    String name;
    List<Product> products = new LinkedList<>();

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public static Manufacturer createManufacturerFrom(ManufacturerContext context) {
        return new Manufacturer(
                context.getName()
        );
    }
}
