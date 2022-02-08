package com.hevo.dao.mapper;

import com.hevo.representation.Employee;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements ResultSetMapper<Employee> {
    @Override
    public Employee map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new Employee(r.getInt("id"),r.getString("firstName"),r.getString("lastName"),r.getString("phone"));
    }
}
