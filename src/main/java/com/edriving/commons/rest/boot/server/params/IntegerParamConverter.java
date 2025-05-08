package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

public class IntegerParamConverter implements ParamConverter<Integer> {
    private Integer parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Integer", 400);
        }
    }
    private String format(Integer value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    @Override
    public Integer fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(Integer value) {
        return format(value);
    }
}
