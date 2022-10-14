package com.eldermoraes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("compra-coreografada")
public class CompraOrquestradaResource {
    
    @Inject
    PedidoService pedidoService;

    @GET
    @Path("teste")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saga(){

        Long id = 0L;

        pedidoService.newPedido(++id, 20);
        pedidoService.newPedido(++id, 30);
        pedidoService.newPedido(++id, 40);
        pedidoService.newPedido(++id, 15);

        return Response.ok().build();
    }

}
