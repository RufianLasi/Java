package com.example.ms_pedidos.Controller;

import com.example.ms_pedidos.DTO.PedidoDTO;
import com.example.ms_pedidos.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> crearPedido(
            @RequestBody PedidoDTO request){

        return ResponseEntity.ok(
                pedidoService.crearPedido(request)
        );
    }


    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        return ResponseEntity.ok(pedidoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> actualizarPedido(
            @PathVariable Integer id,
            @RequestBody PedidoDTO request) {

        return ResponseEntity.ok(
                pedidoService.actualizarPedido(id, request)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPedido(
            @PathVariable Integer id) {

        boolean eliminado = pedidoService.eliminarById(id);

        if (eliminado) {
            return ResponseEntity.ok("pedido eliminado");
        }

        return ResponseEntity.status(404)
                .body("pedido no encontrado");
    }





}
