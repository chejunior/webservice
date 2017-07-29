package com.mike.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class JerseyClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		String result = client.target("http://localhost:8080/jerseyws/restapi/myresource").request().get(String.class);
		System.out.println(result);

	}

}
