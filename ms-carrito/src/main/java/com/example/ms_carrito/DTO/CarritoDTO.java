package com.example.ms_carrito.DTO;

import lombok.Data;

@Data
public class CarritoDTO {

    private Integer productoId;
    private String nombreProducto;
    private Double precio;
    private Integer cantidad;
}