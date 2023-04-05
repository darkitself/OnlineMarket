package com.study.onlinemarket.domain.entity;

import com.study.onlinemarket.domain.entity.context.ProductContext;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    BigDecimal price;

    Long count;

    String name;

    String description;

    @ManyToOne()
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    public static Product createProductFrom(ProductContext context) {
        return Product.builder()
                .count(context.getCount())
                .price(context.getPrice())
                .name(context.getName())
                .description(context.getDescription())
                .manufacturer(context.getManufacturer())
                .build();
    }
}
