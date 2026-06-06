package com.example.ms_pedidos.Service;

import com.example.ms_pedidos.Entity.Pedido;
import com.example.ms_pedidos.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido crearPedido(Pedido pedido){
        Pedido Entity = Pedido.builder()
                .id(pedido.getId())
                .numPedido(pedido.getNumPedido())
                .estado(pedido.getEstado())
                .build();

        return pedidoRepository.save(Entity);
    }


}
