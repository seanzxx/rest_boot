package com.edriving.commons.rest.boot.server.adapter;

import com.google.gson.*;
import jakarta.ws.rs.WebApplicationException;

import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.Instant;

public class InstantAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

    protected Instant parse(Long value) {
        if (value == null) {
            return null;
        }
        try {
            return Instant.ofEpochMilli(value);
        } catch (DateTimeException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Instant. Value must be set as milliseconds from the epoch of 1970-01-01T00:00:00Z", 400);
        }
    }
    protected Instant parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return parse(Long.parseLong(value));
        } catch (NumberFormatException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Instant. Value must be set as milliseconds from the epoch of 1970-01-01T00:00:00Z", 400);
        }
    }
    protected String format(Instant value) {
        if (value == null) {
            return null;
        }
        return "" + value.toEpochMilli();
    }

    @Override
    public JsonElement serialize(Instant instant, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(instant.toEpochMilli());
    }

    @Override
    public Instant deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return parse(jsonElement.getAsLong());
    }
}
