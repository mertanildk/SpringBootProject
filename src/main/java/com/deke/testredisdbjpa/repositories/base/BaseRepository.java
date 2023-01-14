package com.deke.testredisdbjpa.repositories.base;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("baseRepository")
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String>  {
}

