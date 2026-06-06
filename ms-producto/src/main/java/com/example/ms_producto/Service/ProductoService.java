package com.example.ms_producto.Service;

import com.example.ms_producto.DTO.ProductoRequest;
import com.example.ms_producto.DTO.ProductoResponse;
import com.example.ms_producto.Entity.Producto;
import com.example.ms_producto.Repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;


    public ProductoResponse crearProducto(ProductoRequest request){

        Producto producto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .precio(request.getPrecio())
                .stock(request.getStock())
                .categoria(request.getCategoria())
                .build();

        Producto save = productoRepository.save(producto);

        ProductoResponse response = new ProductoResponse();
        response.setId(save.getId());
        response.setNombre(save.getNombre());
        response.setDescripcion(save.getDescripcion());
        response.setCategoria(save.getCategoria());
        response.setStock(save.getStock());
        response.setPrecio(save.getPrecio());

        return response;
    }


    public List<ProductoResponse> listAll(){
        return productoRepository.findAll()
                .stream()
                .map(producto -> {
                    ProductoResponse response = new ProductoResponse();
                    response.setId(producto.getId());
                    response.setNombre(producto.getNombre());
                    response.setDescripcion(producto.getDescripcion());
                    response.setCategoria(producto.getCategoria());
                    response.setStock(producto.getStock());
                    response.setPrecio(producto.getPrecio());
                    return response;
                        }
                )
                .toList();

    }

    public ProductoResponse findById(Integer id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("producto no encontrado"));

        ProductoResponse response = new ProductoResponse();
        response.setId(producto.getId());
        response.setNombre(producto.getNombre());
        response.setDescripcion(producto.getDescripcion());
        response.setCategoria(producto.getCategoria());
        response.setStock(producto.getStock());
        response.setPrecio(producto.getPrecio());

        return response;
    }


    public ProductoResponse actualizarProducto(Integer id, ProductoRequest request){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("producto no encontrado"));

        producto.setNombre(request.getNombre());
        producto.setCategoria(request.getCategoria());
        producto.setDescripcion(request.getDescripcion());
        producto.setStock(request.getStock());
        producto.setPrecio(request.getPrecio());

        Producto update = productoRepository.save(producto);

        ProductoResponse response = new ProductoResponse();
        response.setId(update.getId());
        response.setNombre(update.getNombre());
        response.setDescripcion(update.getDescripcion());
        response.setCategoria(update.getCategoria());
        response.setStock(update.getStock());
        response.setPrecio(update.getPrecio());

        return response;
    }


    public Boolean eliminarById(Integer id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
