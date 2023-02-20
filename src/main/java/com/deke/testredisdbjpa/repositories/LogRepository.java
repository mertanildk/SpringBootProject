package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log,String> {
}
