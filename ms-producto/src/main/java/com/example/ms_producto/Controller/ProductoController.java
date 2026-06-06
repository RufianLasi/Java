package com.example.ms_producto.Controller;

import com.example.ms_producto.DTO.ProductoRequest;
import com.example.ms_producto.DTO.ProductoResponse;
import com.example.ms_producto.Service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAll(){
        return ResponseEntity.ok(productoService.listAll());
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> saveProducto(@Valid @RequestBody ProductoRequest request){
        return ResponseEntity.ok(productoService.crearProducto(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> findProductoById(@PathVariable Integer id){
        return ResponseEntity.ok(productoService.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizarProducto(@PathVariable Integer id, @Valid @RequestBody ProductoRequest request){
        return ResponseEntity.ok(productoService.actualizarProducto(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer id){
        Boolean eliminado = productoService.eliminarById(id);
        if(eliminado){
            return ResponseEntity.ok("producto eliminado");
        }

        return ResponseEntity.status(404).body("producto no encontrado");
    }
}
