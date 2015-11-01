package org.ofbiz.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/demo")    
public class RestfulDemo {  
	
	
        @GET    
        @Produces(MediaType.TEXT_PLAIN)    
        public String sayHello() {    
            return "Hello World!" ;    
        }    
         
            
        @GET    
        @Path("/{param}")      
        @Produces("text/plain;charset=UTF-8")    
        public String sayHelloToUTF8(@PathParam("param") String username) {    
            return "Hello " + username;    
        }    
          
 
}  