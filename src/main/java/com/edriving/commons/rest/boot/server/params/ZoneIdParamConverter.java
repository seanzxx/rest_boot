package com.edriving.commons.rest.boot.server.params;

import com.edriving.commons.rest.boot.server.adapter.ZonedIdAdapter;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.ZoneId;

public class ZoneIdParamConverter
        extends ZonedIdAdapter
        implements ParamConverter<ZoneId> {
    @Override
    public ZoneId fromString(String value) {
        return parse(value);
    }

    @Override
    public String toString(ZoneId value) {
        return format(value);
    }
}
