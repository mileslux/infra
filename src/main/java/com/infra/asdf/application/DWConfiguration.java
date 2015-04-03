package com.infra.asdf.application;

/**
 * Created by nop on 2/18/15.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
//import io.dropwizard.discovery.DiscoveryFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DWConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }



//    @Valid
//    @NotNull
//    private DiscoveryFactory discovery = new DiscoveryFactory();

//    @JsonProperty("discovery")
//    public DiscoveryFactory getDiscoveryFactory() {
//        return discovery;
//    }

//    @JsonProperty("discovery")
//    public void setDiscoveryFactory(DiscoveryFactory discoveryFactory) {
//        this.discovery = discoveryFactory;
//    }
}
