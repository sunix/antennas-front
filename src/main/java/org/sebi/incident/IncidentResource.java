package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("rest/incidents")
public class IncidentResource {

    @Inject
    @RestClient
    IncidentService service;

    @ConfigProperty(name="apikey", defaultValue="toto")
    String api_key;

    @GET
    public List<Incident> getIncidents(){

        return service.getIncidents(api_key);
    }
}
