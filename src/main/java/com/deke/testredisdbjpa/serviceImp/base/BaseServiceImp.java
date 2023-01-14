package com.deke.testredisdbjpa.serviceImp.base;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import com.deke.testredisdbjpa.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;



public abstract class BaseServiceImp<T extends BaseEntity, E, DAO extends BaseRepository<T>, F> implements BaseService<T, String>  {

    @Autowired
    private DAO dao;


    @Override
    public T save(T entity) {
        return dao.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T insert(T t) {
        Date newDate = new Date();
        t.setCreatedAt(newDate);
        t.setLastupdated(newDate);
        return dao.save(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<T> insert(Iterable<T> iterable) {
        return dao.saveAll(iterable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T update(T t) {
        t.setLastupdated(new Date());
        return dao.save(t);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public List<T> saveAll(List<T> t) {
        t.forEach(this::save);
        return t;
    }
    @Override
    public List<T> updateAll(List<T> t) {
        t.forEach(this::update);
        return t;
    }

    @Override
    public void deleteAll(Iterable<T> entities) {
        dao.deleteAll(entities);
    }

    @Override
    public Iterable<T> findAll() {
        return dao.findAll();
    }

    @Override
    public long count() {
        return dao.count();
    }
    @Override
    public Optional<T> findOne(String id) {
        return dao.findById(id);
    }
    @Override
    public List<T> getList(){
        return dao.findAll();
    }

    public DAO getDao() {
        return dao;
    }



}
