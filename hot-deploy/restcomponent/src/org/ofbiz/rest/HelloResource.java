package org.ofbiz.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/hello")
public class HelloResource{
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}

}