package com.redhat.examples.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.redhat.examples.dropwizard.resources.HolaRestResource;

public class HolaDropwizardApplication extends Application<HolaDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HolaDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "HolaDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<HolaDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    	// Enable variable substitution with environment variables
    	bootstrap.setConfigurationSourceProvider
    	(
    			new SubstitutingSourceProvider(
    					bootstrap.getConfigurationSourceProvider(),
    					new EnvironmentVariableSubstitutor(false))
    	);
    	
    }

    @Override
    public void run(final HolaDropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
//		environment.jersey().register(new HolaRestResource());	
    	environment.jersey().register(
    			new HolaRestResource(configuration
    			.getSayingFactory()
    			.getSaying()));
    }

}
