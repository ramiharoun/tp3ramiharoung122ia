package com.example.tp3ramiharoung122ia.resources;

import com.example.tp3ramiharoung122ia.llm.LlmClientRest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
@Produces(MediaType.APPLICATION_JSON)
public class GuideTouristiqueResource {

    @Inject
    LlmClientRest llm;

    @GET
    @Path("lieu/{ville_ou_pays}")
    public Response villeOuPays(@PathParam("ville_ou_pays") String lieu) {
        String resultat = llm.assistant().guide(lieu);
        return Response.ok(resultat).build();
    }
}