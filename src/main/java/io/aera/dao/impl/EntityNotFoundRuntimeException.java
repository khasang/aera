package io.aera.dao.impl;

public class EntityNotFoundRuntimeException extends RuntimeException {
    public EntityNotFoundRuntimeException(String entityClass, String id) {
        super(String.format("%s with ID(%s) not found at database", entityClass, id));
    }
}
