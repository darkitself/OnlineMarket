package com.study.onlinemarket.adapter.repository.base;

import com.study.onlinemarket.adapter.repository.generator.IdGenerator;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Абстрактный репозиторий с наивной реализацией базовых методов. Используется как заглушка до перехода к 'настоящим' репозиториям  <br><br>
 * От него наследуются все используемые репозитории, за счёт реализации JpaRepository при переходе достаточно будет
 * начать наследовать свои репозитории напрямую от JpaRepository
 */
public abstract class BaseStubRepository<T extends BaseDomainEntity<ID>, ID> implements JpaRepository<T, ID> {

    Map<ID, T> entities = new ConcurrentHashMap<>();

    IdGenerator<ID> idGenerator;

    public BaseStubRepository(IdGenerator<ID> idGenerator) {
        this.idGenerator = idGenerator;
    }


    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public List<T> findAll(Sort sort) {
        throw new NotYetImplementedException();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return StreamSupport.stream(ids.spliterator(), false)
                .map(entities::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return entities.size();
    }

    @Override
    public void deleteById(ID id) {
        entities.remove(id);
    }

    @Override
    public void delete(T entity) {
        entities.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends ID> IDs) {
        IDs.forEach(
                id -> entities.remove(id)
        );
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(
                entity -> this.entities.remove(entity.getId())
        );
    }

    @Override
    public void deleteAll() {
        entities.clear();
    }

    @Override
    public <S extends T> S save(S entity) {
        if (entity.isIdNotInitialized()) {
            ID id = idGenerator.generateNextFor(entity.getClass());
            entity.initId(id);
        }
        entities.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .filter(Objects::nonNull)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return entities.containsKey(id);
    }

    @Override
    public void flush() {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new NotYetImplementedException();
    }

    @Override
    public void deleteAllInBatch(Iterable<T> entities) {
        throw new NotYetImplementedException();
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<ID> IDs) {
        throw new NotYetImplementedException();
    }

    @Override
    public void deleteAllInBatch() {
        throw new NotYetImplementedException();
    }

    @Override
    public T getOne(ID aID) {
        throw new NotYetImplementedException();
    }

    @Override
    public T getById(ID aID) {
        throw new NotYetImplementedException();
    }

    @Override
    public T getReferenceById(ID aID) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        throw new NotYetImplementedException();
    }

    @Override
    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new NotYetImplementedException();
    }
}
