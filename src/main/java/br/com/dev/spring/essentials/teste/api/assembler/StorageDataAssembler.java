package br.com.dev.spring.essentials.teste.api.assembler;

import br.com.dev.spring.essentials.api.mapper.Mapper;
import br.com.dev.spring.essentials.teste.api.dto.StorageDataRequest;
import br.com.dev.spring.essentials.teste.api.dto.StorageDataResponse;
import br.com.dev.spring.essentials.teste.domain.entities.StorageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorageDataAssembler implements BaseAssembler<StorageDataResponse, StorageData> {

    @Autowired
    Mapper mapper;

    @Override
    public StorageDataResponse toResponse(StorageData storageData) {
        return mapper.mapObject(storageData, StorageDataResponse.class);
    }

    @Override
    public List<StorageDataResponse> toResponse(List<StorageData> storageDataList) {
        return mapper.mapList(storageDataList, StorageDataResponse.class);
    }
}
