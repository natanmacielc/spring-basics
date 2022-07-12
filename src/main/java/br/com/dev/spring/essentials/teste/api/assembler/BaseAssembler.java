package br.com.dev.spring.essentials.teste.api.assembler;

import java.util.List;

public interface BaseAssembler<Response, Entity> {

    Response toResponse(Entity object);

    List<Response> toResponse(List<Entity> objectList);

}
