package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

public class LongParamConverter implements ParamConverter<Long> {
    private Long parse(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Long", 400);
        }
    }
    @Override
    public Long fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(Long value) {
        return value == null ? null : value.toString();
    }
}
