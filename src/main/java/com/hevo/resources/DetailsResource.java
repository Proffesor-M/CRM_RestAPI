package com.hevo.resources;

import com.hevo.dao.EmployeeDAO;
import com.hevo.representation.Employee;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class DetailsResource {
    private final EmployeeDAO employeeDao;

    public DetailsResource(DBI jdbi) {
        employeeDao = jdbi.onDemand(EmployeeDAO.class);;
    }

    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") int id) {
        Employee employee=employeeDao.getEmployeeById(id);
        return Response.ok(employee).build();
    }
    @POST
    public Response createEmployee(Employee employee) {
        // store the new contact
        return Response.created(null).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") int id,Employee employee) {
        //update the contact
        return Response.ok(new Employee(id,employee.getFirstName(), employee.getLastName(), employee.getPhone())).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...
        return Response.noContent().build();
    }
}
