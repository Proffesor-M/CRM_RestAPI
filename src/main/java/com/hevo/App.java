package com.hevo;

import com.hevo.resources.EmployeeResource;
import com.hevo.security.CRM_Authenticator;
import com.hevo.security.User;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
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
        System.out.println( "Hello" );
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(e, c.getDataSourceFactory(), "mysql");

        //resource environment
        e.jersey().register(new EmployeeResource(jdbi));

        //Auth Environment
        e.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new CRM_Authenticator(jdbi))
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        e.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        e.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
}
