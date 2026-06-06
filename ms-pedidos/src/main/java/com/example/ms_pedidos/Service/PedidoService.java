package com.example.ms_pedidos.Service;

import com.example.ms_pedidos.DTO.PedidoDTO;
import com.example.ms_pedidos.Entity.Pedido;
import com.example.ms_pedidos.Repository.PedidoRepository;
import com.example.ms_pedidos.enums.EstadoPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoDTO crearPedido(PedidoDTO request){

        Pedido pedido = Pedido.builder()
                .numPedido(request.getNumPedido())
                .estado(EstadoPedido.creado)
                .total(request.getTotal())
                .build();

        Pedido save = pedidoRepository.save(pedido);

        PedidoDTO response = new PedidoDTO();
        response.setNumPedido(save.getNumPedido());
        response.setEstado(save.getEstado().name());
        response.setTotal(save.getTotal());

        return response;
    }

    public List<PedidoDTO> listAll() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedido -> {
                    PedidoDTO response = new PedidoDTO();
                    response.setNumPedido(pedido.getNumPedido());
                    response.setEstado(pedido.getEstado().name());
                    response.setTotal(pedido.getTotal());
                    return response;
                })
                .toList();
    }

    public PedidoDTO findById(Integer id) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pedido no encontrado"));

        PedidoDTO response = new PedidoDTO();
        response.setNumPedido(pedido.getNumPedido());
        response.setEstado(pedido.getEstado().name());
        response.setTotal(pedido.getTotal());

        return response;
    }


    public PedidoDTO actualizarPedido(Integer id, PedidoDTO request) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("pedido no encontrado"));

        pedido.setNumPedido(request.getNumPedido());
        pedido.setEstado(EstadoPedido.valueOf(request.getEstado()));
        pedido.setTotal(request.getTotal());

        Pedido update = pedidoRepository.save(pedido);

        PedidoDTO response = new PedidoDTO();
        response.setNumPedido(update.getNumPedido());
        response.setEstado(update.getEstado().name());
        response.setTotal(update.getTotal());

        return response;
    }


    public Boolean eliminarById(Integer id) {

        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;

        }

        return false;
    }


}
