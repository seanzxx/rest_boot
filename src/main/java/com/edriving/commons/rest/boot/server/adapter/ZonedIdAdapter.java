package com.edriving.commons.rest.boot.server.adapter;

import com.google.gson.*;
import jakarta.ws.rs.WebApplicationException;

import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.ZoneId;

public class ZonedIdAdapter implements JsonSerializer<ZoneId>, JsonDeserializer<ZoneId> {

    protected ZoneId parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return ZoneId.of(value);
        } catch (DateTimeException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to ZoneID", 400);
        }
    }
    protected String format(ZoneId value) {
        if (value == null) {
            return null;
        }
        return value.getId();
    }
    @Override
    public JsonElement serialize(ZoneId src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(format(src));
    }
    @Override
    public ZoneId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return parse(json.getAsString());
    }
}
