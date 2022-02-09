package com.hevo.security;


import com.hevo.dao.UserDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.skife.jdbi.v2.DBI;
import java.util.Optional;

public class CRM_Authenticator implements Authenticator<BasicCredentials, User> {
    private final UserDAO userDao;
    public CRM_Authenticator(DBI jdbi){
            userDao = jdbi.onDemand(UserDAO.class);
    }
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException{

        // This is where you should call your authentication service and validate the token

            if (userDao.validatePassword(credentials.getPassword())>0)
            {
                return Optional.of(new User("H"));
            }
            return Optional.empty();
    }
}