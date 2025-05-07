package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

public class IntegerParamConverter implements ParamConverter<Integer> {
    private Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Integer", 400);
        }
    }
    @Override
    public Integer fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(Integer value) {
        return value == null ? null : value.toString();
    }
}
