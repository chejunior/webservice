package com.mike.jaxrs.client;

import javax.ws.rs.client.InvocationCallback;

public class ChecksResponseCallBackHandler implements InvocationCallback<Boolean> {

	@Override
	public void completed(Boolean response) {
		// TODO Auto-generated method stub
		System.out.println("Success: "+response);
	}

	@Override
	public void failed(Throwable e) {
		// TODO Auto-generated method stub
		e.printStackTrace();
	}

}
