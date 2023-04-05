package com.study.onlinemarket.domain.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public abstract class BaseDomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    public int hashCode() {
        return id.hashCode();
    }
}
