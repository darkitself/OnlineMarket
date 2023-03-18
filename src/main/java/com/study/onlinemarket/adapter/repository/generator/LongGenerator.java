package com.study.onlinemarket.adapter.repository.generator;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class LongGenerator implements IdGenerator<Long> {

    Map<Class<?>, Long> nextIds = new ConcurrentHashMap<>();

    @Override
    public Long generateNextFor(Class<?> clazz) {
        Long lastId = nextIds.getOrDefault(clazz, 1L);
        nextIds.put(clazz, lastId + 1);
        return lastId;
    }
}
