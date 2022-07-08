package br.com.dev.spring.essentials.api.mapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Builder
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    public <D> D mapObject(Object source, Class<D> targetClass) {
        return this.modelMapper.map(source, targetClass);
    }

    public <S,T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> this.modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}
