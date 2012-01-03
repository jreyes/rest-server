package com.vaporwarecorp.rest.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/elementos")
public class ElementoQuimicoServicio
{
// ------------------------------ FIELDS ------------------------------

    private ElementoQuimicoDAO dao = new ElementoQuimicoDAO();

// -------------------------- OTHER METHODS --------------------------

    @GET
    @Path("numero/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ElementoQuimico encontrarPorNumeroAtomico( @PathParam("id") int numeroAtomico )
    {
        return dao.encontratPorNumeroAtomico( numeroAtomico );
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ElementoQuimico> encontrarTodos()
    {
        return dao.encontrarTodos();
    }
}
