package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

public class LongParamConverter implements ParamConverter<Long> {
    private Long parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Long", 400);
        }
    }
    private String format(Long value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    @Override
    public Long fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(Long value) {
        return format(value);
    }
}
