package com.newtownscriptkiddies.ama;

import com.newtownscriptkiddies.ama.resources.QuestionsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class AmaApplication extends Application<AmaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AmaApplication().run(args);
    }

    @Override
    public String getName() {
        return "Ama";
    }

    @Override
    public void initialize(final Bootstrap<AmaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final AmaConfiguration configuration,
                    final Environment environment) {
        final QuestionsResource questionsResource = new QuestionsResource();

        environment.jersey().register(questionsResource);
    }

}
