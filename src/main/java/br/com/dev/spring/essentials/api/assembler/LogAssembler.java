package br.com.dev.spring.essentials.api.assembler;

import br.com.dev.spring.essentials.api.dto.LogOut;
import br.com.dev.spring.essentials.api.mapper.Mapper;
import br.com.dev.spring.essentials.domain.entities.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.dev.spring.essentials.api.mapper.Mapper;
import java.util.List;

@Component
public class LogAssembler {

    @Autowired
    private Mapper mapper;

    public List<LogOut> toDto(List<Log> logList){
        return this.mapper.mapList(logList, LogOut.class);
    }
    public LogOut toDto(Log log){
        return this.mapper.mapObject(log, LogOut.class);
    }
}
