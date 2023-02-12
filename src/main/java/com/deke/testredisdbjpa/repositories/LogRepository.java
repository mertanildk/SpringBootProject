package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,String> {
}
