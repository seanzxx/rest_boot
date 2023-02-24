package com.edriving.commons.rest.boot.admin;

import javax.ws.rs.ext.Provider;

@Provider
public interface Heartbeat {
    String probe();
}
