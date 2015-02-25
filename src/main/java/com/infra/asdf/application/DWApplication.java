package com.infra.asdf.application;

import com.infra.asdf.application.health.SomeResourceHCheck;
import com.infra.asdf.application.resources.SomeResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by nop on 2/18/15.
 */
public class DWApplication extends Application<DWConfiguration> {
    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DWConfiguration> bootstrap) {
    }

    @Override
    public void run(DWConfiguration configuration,
                    Environment environment) {

        final SomeResource resource =
                new SomeResource(
                    configuration.getTemplate(),
                    configuration.getDefaultName()
                    );
        final SomeResourceHCheck hcheck =
                new SomeResourceHCheck();

        environment.healthChecks().register("someresourcehealthcheck", hcheck);
        environment.jersey().register(resource);
    }
}
