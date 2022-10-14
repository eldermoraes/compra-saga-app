package com.eldermoraes;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PedidoService {
    
    private Set<Long> pedidos = new HashSet<>();

    @Inject
    CreditoService creditoService;

    public void newPedido(Long id, int valor){
        pedidos.add(id);

        try{
            creditoService.newPedidoValor(id, valor);
            System.out.println("Pedido " + id + " registrado no valor de " + valor + ". Saldo disponível: " + creditoService.getCreditoTotal());
        } catch (IllegalStateException e){
            cancelPedido(id);
            System.err.println("Pedido " + id + " estornado no valor de " + valor);
        }        
    }

    public void cancelPedido(Long id){
        pedidos.remove(id);
    }
}
