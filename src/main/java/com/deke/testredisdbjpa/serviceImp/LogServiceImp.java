package com.deke.testredisdbjpa.serviceImp;


import com.deke.testredisdbjpa.entity.dto.LogAddDto;
import com.deke.testredisdbjpa.repositories.LogRepository;
import com.deke.testredisdbjpa.service.LogService;
import com.deke.testredisdbjpa.entity.Log;
import com.deke.testredisdbjpa.utils.mapping.modelMapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImp implements LogService{

    private final LogRepository logRepository;
    private final ModelMapperService modelMapper;
    @Override
    public Log createLog(LogAddDto logAddDto) {
        Log log = modelMapper.forClass().map(logAddDto, Log.class);
        return logRepository.save(log);
    }

    @Override
    public void deleteLog(String logGuid) {
        logRepository.delete(logRepository.findById(logGuid).orElseThrow());
    }
}
