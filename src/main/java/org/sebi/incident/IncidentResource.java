package org.sebi.incident;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("rest/incidents")
public class IncidentResource {
    
    @Inject
    @RestClient
    IncidentService service;
    

    @GET
    public List<Incident> getIncidents(){
       List<Incident> incidents = service.getAll("secret");
       System.out.println(incidents);
       return incidents;
    } 
}
