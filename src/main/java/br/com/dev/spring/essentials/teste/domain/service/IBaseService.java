package br.com.dev.spring.essentials.teste.domain.service;

import java.util.List;

public interface IBaseService<Response, Request> {

    Response getResource(final Long id);

    List<Response> getResourceCollection();

    Response createResource(final Request request);

    Response modifyResource(final Long id, Request request);
}
