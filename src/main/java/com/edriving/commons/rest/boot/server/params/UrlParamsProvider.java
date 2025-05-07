package com.edriving.commons.rest.boot.server.params;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Provider
public class UrlParamsProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(Instant.class)) {
            return (ParamConverter<T>) new InstantParamConverter();
        } else if (rawType.equals(LocalDate.class)) {
            return (ParamConverter<T>) new LocalDateParamConverter();
        } else if (rawType.equals(LocalDateTime.class)) {
            return (ParamConverter<T>) new LocalDateTimeParamConverter();
        } else if (rawType.equals(ZoneId.class)) {
            return (ParamConverter<T>) new ZoneIdParamConverter();
        } else if (rawType.equals(Integer.class)) {
            return (ParamConverter<T>) new IntegerParamConverter();
        } else if (rawType.equals(Long.class)) {
            return (ParamConverter<T>) new LongParamConverter();
        } else if (rawType.equals(Boolean.class)) {
            return (ParamConverter<T>) new BooleanParamConverter();
        }
        return null;
    }
}
