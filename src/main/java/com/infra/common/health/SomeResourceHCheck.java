package com.infra.common.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by nop on 2/18/15.
 */
public class SomeResourceHCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
