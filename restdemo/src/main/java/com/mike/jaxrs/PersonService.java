package com.mike.jaxrs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({"application/xml", "application/json"})
public interface PersonService {

	@GET
	@Path("/persons/{id}")
	public abstract Person getPerson(@PathParam("id") String id);

	@PUT
	@Path("/persons/")
	public abstract Response updatePerson(Person person);

	@POST
	@Path("/persons/")
	public abstract Response addPerson(Person person);

	@DELETE
	@Path("/persons/{id}")
	public abstract Response deletePerson(@PathParam("id") String id);
	
	@Path("/games/{id}")
	public abstract Game getGame(@PathParam("id") String gameId);

}
