package com.edriving.commons.rest.boot.server.adapter;

import com.google.gson.*;
import jakarta.ws.rs.WebApplicationException;

import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeAdapter implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    protected ZonedDateTime parse(String value) {
        if (value == null) {
            return null;
        }
        try {
            return ZonedDateTime.parse(value, DATE_FORMAT);
        } catch (DateTimeException t) {
            throw new WebApplicationException("cannot parse '" + value + "' to Zoned Date Time", 400);
        }
    }
    protected String format(ZonedDateTime value) {
        if (value == null) {
            return null;
        }
        return value.format(DATE_FORMAT);
    }


    @Override
    public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(format(src));
    }

    @Override
    public ZonedDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return parse(json.getAsString());
    }
}
