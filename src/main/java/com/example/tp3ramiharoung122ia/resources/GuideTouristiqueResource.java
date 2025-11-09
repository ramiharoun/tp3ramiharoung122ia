package com.example.tp3ramiharoung122ia.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("/lieu/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] obtenirInfos(@PathParam("nom") String nomLieu) {
        String[] resultat = { nomLieu };
        return resultat;
    }
}