package br.com.dev.spring.essentials.teste.domain.service;

import br.com.dev.spring.essentials.teste.domain.exceptions.StorageNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseService<Response, Request> implements IBaseService<Response, Request> {

    @Override
    public Response getResource(Long id) {
        List<Object> objectList = new ArrayList<>();
        Optional<Object> object = Optional.of(objectList.indexOf(id));

        if (Objects.isNull(object.get())) {
            throw new RuntimeException("resource not found.");
        }

        return (Response) object.get();
    }

    @Override
    public List<Response> getResourceCollection() {
        List<Object> objectList = new ArrayList<>();

        if (objectList.isEmpty()) {
            throw new StorageNotFoundException("resource is empty.");
        }

        return (List<Response>) objectList;
    }

    @Override
    public Response createResource(Request request) {
        return (Response) request;
    }

    @Override
    public Response modifyResource(Long id, Request request) {
        List<Object> objectList = new ArrayList<>();
        Optional<Object> object = Optional.of(objectList.indexOf(id));

        if (object.isEmpty()) {
            throw new RuntimeException("this resource does not exists.");
        }

        object = Optional.of(request);

        return (Response) object;
    }
}
