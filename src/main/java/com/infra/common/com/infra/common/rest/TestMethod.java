package com.infra.common.com.infra.common.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by nop on 2/16/15.
 */
@Path("/test-method")
public class TestMethod {
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {
        return "Beware, mortal! I am a TestMethod!";
    }
}

