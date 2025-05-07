package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.DateTimeException;
import java.time.Instant;

public class InstantParamConverter implements ParamConverter<Instant> {
    private Instant parse(String value) {
        try {
            return Instant.ofEpochMilli(Long.parseLong(value));
        } catch (NumberFormatException | DateTimeException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Instant. Value must be set as milliseconds from the epoch of 1970-01-01T00:00:00Z", 400);
        }
    }
    @Override
    public Instant fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(Instant value) {
        return value == null ? null : ("" + value.toEpochMilli());
    }
}
