package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanParamConverter implements ParamConverter<Boolean> {

    private static final Set<String> VALUES = new HashSet<>(Arrays.asList("true", "false"));

    private Boolean parse(String value) {
        if (!VALUES.contains(value.toLowerCase())) {
            throw new WebApplicationException("cannot parse '" + value + "' to Boolean. Accepted values are either 'true' or 'false'.", 400);
        }
        return Boolean.parseBoolean(value);
    }
    @Override
    public Boolean fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(Boolean value) {
        return value == null ? null : value.toString();
    }
}
