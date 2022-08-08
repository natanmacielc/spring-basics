package br.com.dev.spring.essentials.teste.domain.service;

import br.com.dev.spring.essentials.teste.api.assembler.StorageDataAssembler;
import br.com.dev.spring.essentials.teste.api.dto.StorageDataRequest;
import br.com.dev.spring.essentials.teste.api.dto.StorageDataResponse;
import br.com.dev.spring.essentials.teste.domain.entities.StorageData;
import br.com.dev.spring.essentials.teste.domain.exceptions.StorageNotFoundException;
import br.com.dev.spring.essentials.teste.domain.repository.StorageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StorageDataService extends BaseService<StorageDataResponse, StorageDataRequest> {

    @Autowired
    StorageDataRepository repository;

    @Autowired
    StorageDataAssembler assembler;

    @Override
    public StorageDataResponse getResource(Long position) {
        Optional<StorageData> storageData = this.repository.findById(position);

        if (storageData.isEmpty()) {
            throw new StorageNotFoundException("data resource not found.");
        }

        return this.assembler.toResponse(storageData.get());
    }

    @Override
    public List<StorageDataResponse> getResourceCollection() {
        List<StorageData> storageDataList = this.repository.findAll();

        if (storageDataList.isEmpty()) {
            throw new StorageNotFoundException("storage data is empty.");
        }

        return this.assembler.toResponse(storageDataList);
    }

    @Override
    public StorageDataResponse createResource(StorageDataRequest storageDataRequest) {
        StorageData storageData = StorageData.builder()
                .name(storageDataRequest.getName())
                .description(storageDataRequest.getDescription())
                .registrationDate(LocalDateTime.now())
                .build();

        this.repository.save(storageData);
        return this.assembler.toResponse(storageData);
    }

    @Override
    public StorageDataResponse modifyResource(Long position, StorageDataRequest storageDataRequest) {
        Optional<StorageData> storageData = this.repository.findById(position);

        if (storageData.isEmpty()) {
            throw new StorageNotFoundException("this storage data does not exists.");
        }

        storageData.get().setName(storageDataRequest.getName());
        storageData.get().setDescription(storageDataRequest.getDescription());
        this.repository.save(storageData.get());

        return this.assembler.toResponse(storageData.get());
    }
}
