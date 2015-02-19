package com.infra.common.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.infra.common.rest.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nop on 2/18/15.
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SomeResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SomeResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
