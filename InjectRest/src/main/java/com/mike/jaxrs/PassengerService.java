package com.mike.jaxrs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import com.mike.jaxrs.dto.Passenger;
import com.mike.jaxrs.dto.PassengerList;

@Path("/Passenger")
@Produces("application/xml")
public class PassengerService {
	PassengerList passengerList = new PassengerList();
	private int id = 123;

	public PassengerService() {
		init();
	}

	public void init() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setId(id);
		passenger.setName("Maik");
		passengers.add(passenger);
		passengerList.setPassengers(passengers);
	}

	@GET
	public PassengerList getPassengers(@QueryParam("start") int start, @QueryParam("size") int size,
			@HeaderParam("agent") String agent, @Context HttpHeaders headers) {
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> names = cookies.keySet();
		
		for(String name:names) {
			System.out.println(cookies.get(name).getValue());
			
		}
		
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> headerNameSet = requestHeaders.keySet();
		
		for(String header:headerNameSet) {
			System.out.println(headers.getHeaderString(header));
		}
		System.out.println("start: " + start);
		System.out.println("size: " + size);
		System.out.println(agent);
		return passengerList;
	}

	@POST
	public void setPassengerList(@FormParam("firstname") String firstName, @FormParam("lastname") String lastName) {
		System.out.println("FN: " + firstName);
		System.out.println("LN: " + lastName);
		Passenger passenger = new Passenger();
		passenger.setId(++id);
		passenger.setName(firstName + " " + lastName);
		passengerList.getPassengers().add(passenger);
	}

}
