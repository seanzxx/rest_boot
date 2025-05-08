package com.edriving.commons.rest.boot.server.adapter;

import com.google.gson.*;
import jakarta.ws.rs.WebApplicationException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    protected LocalDate parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return LocalDate.parse(value, DATE_FORMAT);
        } catch (DateTimeParseException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Local Date", 400);
        }
    }
    protected String format(LocalDate value) {
        if (value == null) {
            return null;
        }
        return value.format(DATE_FORMAT);
    }

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(format(src));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return parse(json.getAsString());
    }
}
