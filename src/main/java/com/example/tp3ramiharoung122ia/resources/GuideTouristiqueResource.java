package com.example.tp3ramiharoung122ia.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] villeOuPays(@PathParam("ville_ou_pays") String lieu) {
        return new String[]{ lieu }; // Étape 2 : ["Paris"]
    }

}