package com.hevo;

import com.hevo.resources.EmployeeResource;
import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<DataConfig> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    @Override
    public void initialize(Bootstrap<DataConfig> b) {}


    @Override
    public void run(DataConfig c, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");
        System.out.println( "Hello world, by Dropwizard!" );
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(e, c.getDataSourceFactory(), "mysql");
        e.jersey().register(new EmployeeResource(jdbi));
    }

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
}
