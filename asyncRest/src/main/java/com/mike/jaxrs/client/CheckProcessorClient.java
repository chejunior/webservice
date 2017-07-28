package com.mike.jaxrs.client;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.springframework.http.MediaType;

import com.mike.jaxrs.Check;
import com.mike.jaxrs.ChecksList;

public class CheckProcessorClient {

	public static void main(String[] args) {
		ChecksList checksList = new ChecksList();
		ArrayList<Check> checks = new ArrayList<Check>();
		checks.add(new Check());
		checksList.setChecks(checks);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/asyncRest/services/checkService/checks");
		AsyncInvoker asyncInvoker = target.request().async();
		Future<Boolean> future = asyncInvoker.post(Entity.entity(checksList, MediaType.APPLICATION_ATOM_XML_VALUE), new ChecksResponseCallBackHandler());
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Future<Boolean> future = asyncInvoker.post(Entity.entity(checksList, MediaType.APPLICATION_ATOM_XML_VALUE),
//				Boolean.class);
//		
//		try {
//			System.out.println(future.get());
//			
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		} catch (ExecutionException e) {
//			if (e.getCause() instanceof BadRequestException) {
//				 BadRequestException be = (BadRequestException) e.getCause();
//				 System.out.println("Checks should be provider");
// 			}
//			// TODO: handle exception
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

}
