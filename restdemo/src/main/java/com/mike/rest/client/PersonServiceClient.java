package com.mike.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mike.jaxrs.Person;

public class PersonServiceClient {

	private static final String PERSON_URL = "http://localhost:8080/restdemo/services/personservice";

	public static void main(String[] args) {
		// GET
		Client client = ClientBuilder.newClient();
		WebTarget getTarget = client.target(PERSON_URL).path("/persons").path("/{id}").resolveTemplate("id", 123);
		Response response = getTarget.request().get();
		Person person = getTarget.request().get(Person.class);
		System.out.println(response.getStatus());
		System.out.println(person.getName());
		response.close();

		// UPDATE
		WebTarget putTarget = client.target(PERSON_URL).path("/persons");
		person.setName("NewName");
		Response putResponse = putTarget.request().put(Entity.entity(person, MediaType.APPLICATION_XML));
		System.out.println(putResponse.getStatus());
		putResponse.close();

		// CREATE
		Person newPerson = new Person();
		newPerson.setName("Person 589");

		WebTarget postTarget = client.target(PERSON_URL).path("/persons");
		Person postPerson = postTarget.request().post(Entity.entity(newPerson, MediaType.APPLICATION_XML),Person.class);
		System.out.println(postPerson.getId());

		// DELETE
		WebTarget deleteTarget = client.target(PERSON_URL).path("/persons").path("/{id}").resolveTemplate("id", postPerson.getId());
		Response deleteResponse = deleteTarget.request().delete();
		System.out.println(deleteResponse.getStatus());
		deleteResponse.close();
		client.close();

	}

}
