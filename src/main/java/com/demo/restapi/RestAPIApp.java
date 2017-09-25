package com.demo.restapi;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class RestAPIApp extends Application<RestAPIConfig> {

    public static void main(String[] args) throws Exception {
        new RestAPIApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<RestAPIConfig> bootstrap) {

        GuiceBundle guiceBundle = GuiceBundle.<RestAPIConfig>newBuilder()
                .addModule(new RestServerModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(RestAPIConfig.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    /**
     * Registers annotation based services
     *
     * @param config
     * @param env
     */
    @Override
    public void run(RestAPIConfig config, Environment env) {
        //Registers annotation based services automatically
    }
}