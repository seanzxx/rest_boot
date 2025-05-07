package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeParamConverter implements ParamConverter<LocalDateTime> {
    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private LocalDateTime parse(String value) {
        try {
            return LocalDateTime.parse(value, DATE_TIME_FORMAT);
        } catch (DateTimeParseException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Local Date And Time", 400);
        }
    }
    @Override
    public LocalDateTime fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(LocalDateTime value) {
        return value == null ? null : value.format(DATE_TIME_FORMAT);
    }
}
