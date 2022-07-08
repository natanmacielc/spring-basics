package br.com.dev.spring.essentials.domain.services;

import br.com.dev.spring.essentials.api.assembler.LogAssembler;
import br.com.dev.spring.essentials.api.dto.LogOut;
import br.com.dev.spring.essentials.domain.entities.Log;
import br.com.dev.spring.essentials.domain.exceptions.LogNotFoundException;
import br.com.dev.spring.essentials.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    @Autowired
    LogAssembler logAssembler;

    public List<LogOut> getResourceCollection() {
        List<Log> logList = logRepository.findAll();

        if (logList.isEmpty()) {
            throw new LogNotFoundException("List is empty");
        }
        return logAssembler.toDto(logList);
    }

    public LogOut getResourceById(Long id){
         Optional<Log> log = logRepository.findById(id);

        if (log.isEmpty()) {
            throw new LogNotFoundException("Id not found");
        }
        return logAssembler.toDto(log.get());
    }
}
