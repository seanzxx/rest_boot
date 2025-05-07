package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.DateTimeException;
import java.time.ZoneId;

public class ZoneIdParamConverter implements ParamConverter<ZoneId> {
    private ZoneId parse(String value) {
        try {
            return ZoneId.of(value);
        } catch (DateTimeException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to ZoneID", 400);
        }
    }
    @Override
    public ZoneId fromString(String value) {
        return value == null ? null : parse(value);
    }
    @Override
    public String toString(ZoneId value) {
        return value == null ? null : value.getId();
    }
}
