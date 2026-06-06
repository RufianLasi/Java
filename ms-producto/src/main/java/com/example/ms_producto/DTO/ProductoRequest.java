package com.example.ms_producto.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotNull
    private Double precio;
    @NotNull
    private Integer stock;
    @NotBlank
    private String categoria;

}
