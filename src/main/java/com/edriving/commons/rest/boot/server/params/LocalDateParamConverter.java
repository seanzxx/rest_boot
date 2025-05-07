package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateParamConverter implements ParamConverter<LocalDate> {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    private LocalDate parse(String value) {
        try {
            return LocalDate.parse(value, DATE_FORMAT);
        } catch (DateTimeParseException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Local Date", 400);
        }
    }
    @Override
    public LocalDate fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(LocalDate value) {
        return value == null ? null : value.format(DATE_FORMAT);
    }
}
