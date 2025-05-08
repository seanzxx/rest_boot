package com.edriving.commons.rest.boot.server.params;

import com.edriving.commons.rest.boot.server.adapter.InstantAdapter;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.Instant;

public class InstantParamConverter
        extends InstantAdapter
        implements ParamConverter<Instant> {
    @Override
    public Instant fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(Instant value) {
        return format(value);
    }
}
