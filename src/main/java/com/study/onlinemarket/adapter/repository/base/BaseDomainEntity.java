package com.study.onlinemarket.adapter.repository.base;

import lombok.Getter;


/**
 * Базовая сущность, от которой должны быть унаследованы все остальные сущности, хранящиеся в бд
 */
@Getter
public abstract class BaseDomainEntity<ID> {
    private ID id;

    public boolean isIdNotInitialized() {
        return id == null;
    }

    public void initId(ID id) {
        if (isIdNotInitialized())
            this.id = id;
    }
}
