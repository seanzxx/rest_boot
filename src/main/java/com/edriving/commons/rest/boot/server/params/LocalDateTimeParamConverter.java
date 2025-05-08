package com.edriving.commons.rest.boot.server.params;

import com.edriving.commons.rest.boot.server.adapter.LocalDateTimeAdapter;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDateTime;

public class LocalDateTimeParamConverter
        extends LocalDateTimeAdapter
        implements ParamConverter<LocalDateTime> {
    @Override
    public LocalDateTime fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(LocalDateTime value) {
        return format(value);
    }
}
