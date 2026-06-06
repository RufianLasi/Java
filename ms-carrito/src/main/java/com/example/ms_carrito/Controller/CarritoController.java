package com.example.ms_carrito.Controller;

import com.example.ms_carrito.DTO.CarritoDTO;
import com.example.ms_carrito.Service.CarritoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @PostMapping
    public ResponseEntity<CarritoDTO> agregarProducto(
            @Valid @RequestBody CarritoDTO request){

        return ResponseEntity.ok(
                carritoService.agregarProducto(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<CarritoDTO>> obtenerCarrito(){

        return ResponseEntity.ok(
                carritoService.listAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable Integer id){

        Boolean eliminado = carritoService.eliminarProducto(id);

        if(eliminado){
            return ResponseEntity.ok("producto eliminado del carrito");
        }

        return ResponseEntity.status(404)
                .body("producto no encontrado");
    }
}