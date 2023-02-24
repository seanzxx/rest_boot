package com.edriving.commons.rest.boot.admin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class HeartbeatResource {
    private static final Heartbeat IMPL = new HeartbeatImplSimple();
    @GET
    @Path("/heartbeat")
    @Produces(MediaType.TEXT_PLAIN)
    public String heartbeat() {
        return IMPL.probe();
    }
}
