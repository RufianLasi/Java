package com.example.ms_carrito.Service;

import com.example.ms_carrito.DTO.CarritoDTO;
import com.example.ms_carrito.Entity.Carrito;
import com.example.ms_carrito.Repository.CarritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoDTO agregarProducto(CarritoDTO request){

        Carrito carrito = Carrito.builder()
                .productoId(request.getProductoId())
                .nombreProducto(request.getNombreProducto())
                .precio(request.getPrecio())
                .cantidad(request.getCantidad())
                .build();

        Carrito save = carritoRepository.save(carrito);

        CarritoDTO response = new CarritoDTO();
        response.setProductoId(save.getProductoId());
        response.setNombreProducto(save.getNombreProducto());
        response.setPrecio(save.getPrecio());
        response.setCantidad(save.getCantidad());

        return response;
    }

    public List<CarritoDTO> listAll(){

        return carritoRepository.findAll()
                .stream()
                .map(carrito -> {
                    CarritoDTO response = new CarritoDTO();

                    response.setProductoId(carrito.getProductoId());
                    response.setNombreProducto(carrito.getNombreProducto());
                    response.setPrecio(carrito.getPrecio());
                    response.setCantidad(carrito.getCantidad());

                    return response;
                })
                .toList();
    }

    public Boolean eliminarProducto(Integer id){

        if(carritoRepository.existsById(id)){
            carritoRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
