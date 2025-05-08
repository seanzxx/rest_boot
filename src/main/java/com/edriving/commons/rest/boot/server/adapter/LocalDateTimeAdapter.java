package com.edriving.commons.rest.boot.server.adapter;

import com.google.gson.*;
import jakarta.ws.rs.WebApplicationException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    protected LocalDateTime parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(value, DATE_TIME_FORMAT);
        } catch (DateTimeParseException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Local Date And Time", 400);
        }
    }
    protected String format(LocalDateTime value) {
        if (value == null) {
            return null;
        }
        return value.format(DATE_TIME_FORMAT);
    }

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return parse(json.getAsString());
    }
}
