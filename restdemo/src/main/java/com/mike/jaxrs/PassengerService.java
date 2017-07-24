package com.mike.jaxrs;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mike.jaxrs.dto.Passenger;
import com.mike.jaxrs.dto.PassengerList;

@Path("/Passenger")
@Produces("application/xml")
public class PassengerService {
	PassengerList passengerList = new PassengerList();
	
	public PassengerService() {
		init();
	}
	
	public void init() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setId(123);
		passenger.setName("Maik");
		passengers.add(passenger);
		passengerList.setPassengers(passengers);
	}

	@GET
	public PassengerList getPassengers(int start, int size) {
		return passengerList;
	}

	@POST
	public void setPassengerList(String firstName, String lastName) {
	}
	
	

}
