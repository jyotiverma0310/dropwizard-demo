package com.demo.restapi;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class RestServerModule implements Module {

    /**
     * Responsible for binding and configuration of module
     *
     * @param binder
     */
    @Override
    public void configure(Binder binder) {
        //binds and configure the module automatically
    }

    @Provides
    @Named("version")
    public String provideMessage(RestAPIConfig serverConfiguration) {
        return serverConfiguration.getVersion();
    }
}
