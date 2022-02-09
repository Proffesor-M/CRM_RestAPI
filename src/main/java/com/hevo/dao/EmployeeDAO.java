package com.hevo.dao;

import com.hevo.dao.mapper.EmployeeMapper;
import com.hevo.representation.Employee;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface EmployeeDAO {

    @Mapper(EmployeeMapper.class)
    @SqlQuery("select * from employee where id = :id")
    Employee getEmployeeById(@Bind("id") int id) ;

    @GetGeneratedKeys
    @SqlUpdate("insert into employee (id, firstName, lastName,phone) values (NULL, :firstName, :lastName, :phone)")
    int createEmployee(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);

    @SqlUpdate("update employee set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
    void updateEmployee(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName,@Bind("phone") String phone);

    @SqlUpdate("delete from Employee where id = :id")
    void deleteEmployee(@Bind("id") int id);
}
