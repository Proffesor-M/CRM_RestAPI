package com.hevo.resources;

import com.hevo.dao.EmployeeDAO;
import com.hevo.representation.Employee;
import com.hevo.security.User;
import io.dropwizard.auth.Auth;
import org.skife.jdbi.v2.DBI;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;


@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final EmployeeDAO employeeDao;

    public EmployeeResource(DBI jdbi) {
        employeeDao = jdbi.onDemand(EmployeeDAO.class);;
    }

    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") int id,@Auth User u ){
        Employee employee=employeeDao.getEmployeeById(id);
        return Response.ok(employee).build();
    }
    
    /* @GET
    public Response getEmployees() {
        Employee employee=employeeDao.getallEmployee();
        return Response.ok(employee).build();}*/

    @POST
    public Response createEmployee(Employee employee,@Auth User user) throws URISyntaxException {
        int newEmployeeId =employeeDao.createEmployee(employee.getFirstName(), employee.getLastName(), employee.getPhone());
        return Response.created(new URI(String.valueOf(newEmployeeId))).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") int id,@Auth User user,Employee employee ) {
        employeeDao.updateEmployee(id, employee.getFirstName(),employee.getLastName(), employee.getPhone());
        return Response.ok(new Employee(id,employee.getFirstName(), employee.getLastName(), employee.getPhone())).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id,@Auth User u ) {
        employeeDao.deleteEmployee(id);
        return Response.noContent().build();
    }
}
