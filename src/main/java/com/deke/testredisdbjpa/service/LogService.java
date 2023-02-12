package com.deke.testredisdbjpa.service;
import com.deke.testredisdbjpa.entity.Log;
import com.deke.testredisdbjpa.entity.dto.LogAddDto;

public interface LogService {

    Log createLog(LogAddDto logAddDto);

    void deleteLog(String logGuid);

    //List<Log> searchLogAll(LogSearchDto logSearchDto);

    //Page<Log> searchLog(LogSearchDto logSearchDto, Pageable pageable);
}
