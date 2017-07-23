package com.mike.jaxrs.exceptions.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mike.jaxrs.exceptions.BusinessException;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException exception) {
		StringBuilder response = new StringBuilder("<response>");
		response.append("<status>ERROR</status>");
		response.append("<message>"+exception.getMessage()+"</message>");
		response.append("</response>");
		return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_XML).build();
	}
	
}
