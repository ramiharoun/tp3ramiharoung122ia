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

    // /api/guide/lieu/Paris?nb=4
    @GET
    @Path("lieu/{ville_ou_pays}")
    public Response villeOuPays(@PathParam("ville_ou_pays") String lieu,
                                @QueryParam("nb") @DefaultValue("2") int nb) {
        String resultat = llm.assistant().guide(lieu, nb);
        return Response.ok(resultat).build();
    }
}
