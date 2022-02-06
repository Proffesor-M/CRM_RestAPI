package com.hevo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * Hello world!
 *
 */
public class App extends Application<DataConfig> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    @Override
    public void initialize(Bootstrap<DataConfig> b) {}



    @Override
    public void run(DataConfig c, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");
        System.out.println( "Hello world, by Dropwizard!" );
    }

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
        //System.out.println( "Hello World!" );
    }
}
