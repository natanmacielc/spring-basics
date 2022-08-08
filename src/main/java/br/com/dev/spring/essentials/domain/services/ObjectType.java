package br.com.dev.spring.essentials.domain.services;

public enum ObjectType {
    ENTITY("br.com.dev.spring.essentials.domain.services");

    String value;

    ObjectType(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }
}
