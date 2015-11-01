package org.ofbiz.rest.party;

import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.ofbiz.base.lang.JSON;
import org.ofbiz.base.util.UtilMisc;
import org.ofbiz.entity.Delegator;
import org.ofbiz.entity.DelegatorFactory;
import org.ofbiz.entity.GenericValue;
import org.ofbiz.service.ServiceUtil;

@Path("/party")
public class PartyRestServices{
	
	
	@GET    
    @Path("/getPerson/{param}")      
    @Produces("text/plain;charset=UTF-8")    
    public String getPerson(@PathParam("param") String partyId) throws Exception {
		Delegator delegator = DelegatorFactory.getDelegator("default");
		GenericValue person = delegator.findOne("Person", false, UtilMisc.toMap("partyId", partyId));
		Map<String, Object> result = ServiceUtil.returnSuccess();
		result.put("person", person);
		JSON json = JSON.from(result);
		return json.toString();    
    }  
	
	@GET    
    @Path("/createPerson")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain;charset=UTF-8")    
    public String createPerson(@Context UriInfo ui) throws Exception {
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		Delegator delegator = DelegatorFactory.getDelegator("default");
		//GenericValue person = delegator.findOne("Person", false, UtilMisc.toMap("partyId", partyId));
		Map<String, Object> result = ServiceUtil.returnSuccess();
		result.put("mapPerson", queryParams);
		JSON json = JSON.from(result);
		return json.toString();    
    }
}