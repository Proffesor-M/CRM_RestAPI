package com.hevo.resources;

import com.hevo.representation.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class DetailsResource {
    @GET
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") int id) {
        // retrieve information about the contact with the provided id
        return Response.ok( new Employee( id, "John", "Doe", "+123456789") ).build();
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
