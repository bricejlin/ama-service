package com.newtownscriptkiddies.ama.api;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class PingResource {
    @GET
    @Timed
    public String ping() {
        return "world";
    }
}
