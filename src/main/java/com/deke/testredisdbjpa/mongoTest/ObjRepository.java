package com.deke.testredisdbjpa.mongoTest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ObjRepository extends MongoRepository<Obj, String> {
}
