package br.com.dev.spring.essentials.api.controller;

import br.com.dev.spring.essentials.api.dto.LogOut;
import br.com.dev.spring.essentials.domain.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("v1/log")
@RestController
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping
    public List<LogOut> getResourceCollection() {
        return logService.getResourceCollection();
    }

    @GetMapping("/{id}")
    public LogOut getResourceById(@PathVariable Long id){
        return logService.getResourceById(id);
    }
}
