package com.edriving.commons.rest.boot.server.params;

import com.edriving.commons.rest.boot.server.adapter.ZonedDateTimeAdapter;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.ZonedDateTime;

public class ZonedDateTimeParamConverter
        extends ZonedDateTimeAdapter
        implements ParamConverter<ZonedDateTime> {
    @Override
    public ZonedDateTime fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(ZonedDateTime value) {
        return format(value);
    }
}
