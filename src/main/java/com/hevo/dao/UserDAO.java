package com.hevo.dao;

import com.hevo.representation.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface UserDAO {

    @SqlQuery("select count(*) from users where password = :password")
    int validatePassword(@Bind("password") String password ) ;
}
