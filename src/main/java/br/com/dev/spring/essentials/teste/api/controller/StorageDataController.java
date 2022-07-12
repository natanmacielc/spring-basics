package br.com.dev.spring.essentials.teste.api.controller;

import br.com.dev.spring.essentials.teste.api.dto.StorageDataRequest;
import br.com.dev.spring.essentials.teste.api.dto.StorageDataResponse;
import br.com.dev.spring.essentials.teste.domain.service.StorageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teste/storagedata")
public class StorageDataController {

    @Autowired
    StorageDataService service;

    @GetMapping(value = "{position}")
    public StorageDataResponse exposeResource(@PathVariable Long position) {
        return this.service.getResource(position);
    }

    @GetMapping
    public List<StorageDataResponse> exposeResourceCollection() {
        return this.service.getResourceCollection();
    }

    @PostMapping
    public StorageDataResponse createResource(@RequestBody StorageDataRequest storageDataRequest) {
        return this.service.createResource(storageDataRequest);
    }

    @PutMapping(value = "{position}")
    public StorageDataResponse modifyResource(@PathVariable Long position, @RequestBody StorageDataRequest storageDataRequest) {
        return this.service.modifyResource(position, storageDataRequest);
    }
}
