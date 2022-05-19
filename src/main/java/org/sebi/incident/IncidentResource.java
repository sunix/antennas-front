package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collections;
import java.util.Date;
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
    @Fallback(fallbackMethod = "fallbackRecommendations")
    public List<Incident> getIncidents(){

        return service.getIncidents(api_key);
    }

    public List<Incident> fallbackRecommendations() {
        Incident incident1 = new Incident();
        incident1.date = new Date();
        incident1.description = "Panne émetteur FallBACK";
        incident1.status = true;
        return List.of(incident1);
    }
}
