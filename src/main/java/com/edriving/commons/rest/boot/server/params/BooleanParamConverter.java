package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanParamConverter implements ParamConverter<Boolean> {

    private static final Set<String> VALUES = new HashSet<>(Arrays.asList("true", "false"));

    private Boolean parse(String value) {
        if (value == null) {
            return null;
        }
        if (!VALUES.contains(value.toLowerCase())) {
            throw new WebApplicationException("cannot parse '" + value + "' to Boolean. Accepted values are either 'true' or 'false'.", 400);
        }
        return Boolean.parseBoolean(value);
    }

    private String format(Boolean value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    @Override
    public Boolean fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(Boolean value) {
        return format(value);
    }
}
