package com.edriving.commons.rest.boot.server.params;

import com.edriving.commons.rest.boot.server.adapter.LocalDateAdapter;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDate;

public class LocalDateParamConverter
        extends LocalDateAdapter
        implements ParamConverter<LocalDate> {
    @Override
    public LocalDate fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(LocalDate value) {
        return format(value);
    }
}
