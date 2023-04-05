package com.study.onlinemarket.domain.entity;

import com.study.onlinemarket.domain.entity.context.ManufacturerContext;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String name;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    List<Product> products = new LinkedList<>();

    public static Manufacturer createManufacturerFrom(ManufacturerContext context) {
        return Manufacturer.builder()
                .name(context.getName())
                .products(new LinkedList<>())
                .build();
    }

    public int hashCode() {
        return id.hashCode();
    }
}
