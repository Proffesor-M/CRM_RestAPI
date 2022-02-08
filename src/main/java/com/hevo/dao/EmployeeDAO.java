package com.hevo.dao;

import com.hevo.dao.mapper.EmployeeMapper;
import com.hevo.representation.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface EmployeeDAO {

    @Mapper(EmployeeMapper.class)
    @SqlQuery("select * from contact where id = :id")
    Employee getEmployeeById(@Bind("id") int id) ;

}
