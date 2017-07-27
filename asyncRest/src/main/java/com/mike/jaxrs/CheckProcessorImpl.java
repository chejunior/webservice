package com.mike.jaxrs;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

public class CheckProcessorImpl {
	@POST
	@Path("/checks")
	public void processCheck(@Suspended AsyncResponse response, CheckList checks) {
		new Thread() {
			public void run() {
				response.resume(true);
			}
		};
	}

}
