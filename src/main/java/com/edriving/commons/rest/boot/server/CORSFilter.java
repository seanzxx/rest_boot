package com.edriving.commons.rest.boot.server;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    private static final String ORIGINS_PROPERTY = "cors-origins";
    private static final String ORIGINS_DEFAULT = "*";
    private static final String METHODS_PROPERTY = "cors-methods";
    private static final String METHODS_DEFAULT = "GET, POST, DELETE, PUT, PATCH, OPTIONS";

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        String allowedMethods = System.getProperty(METHODS_PROPERTY, METHODS_DEFAULT);
        String allowedOrigins = System.getProperty(ORIGINS_PROPERTY, ORIGINS_DEFAULT);
        MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", allowedOrigins);
        headers.add("Access-Control-Allow-Methods", allowedMethods);
    }
}
