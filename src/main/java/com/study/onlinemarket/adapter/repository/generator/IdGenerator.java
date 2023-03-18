package com.study.onlinemarket.adapter.repository.generator;

/**
 * Интерфейс генератора идентификаторов для использования в репозиториях
 */
public interface IdGenerator<ID> {
    ID generateNextFor(Class<?> clazz);
}
