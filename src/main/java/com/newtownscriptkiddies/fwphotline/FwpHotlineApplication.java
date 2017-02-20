package com.newtownscriptkiddies.fwphotline;

import com.newtownscriptkiddies.fwphotline.api.PingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FwpHotlineApplication extends Application<FwpHotlineConfiguration> {

    public static void main(final String[] args) throws Exception {
        new FwpHotlineApplication().run(args);
    }

    @Override
    public String getName() {
        return "FwpHotline";
    }

    @Override
    public void initialize(final Bootstrap<FwpHotlineConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FwpHotlineConfiguration configuration,
                    final Environment environment) {
        final PingResource pingResource = new PingResource();
        environment.jersey().register(pingResource);
    }

}
