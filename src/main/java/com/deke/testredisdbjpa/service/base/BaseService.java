package com.deke.testredisdbjpa.service.base;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, PK extends Serializable> {

        Optional<T> findOne(PK id);

        T insert(T t);

        T update(T t) throws InstantiationException, InvocationTargetException;

        void delete(T t);

        Iterable<T> insert(Iterable<T> iterable);

        Iterable<T> findAll();

        long count();

        List<T> updateAll(List<T> t);

        List<T> saveAll(List<T> t);

        List<T> getList();
        void deleteAll(Iterable<T> entities);

        T save(T f) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
