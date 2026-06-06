package com.example.ms_producto.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false,length = 200)
    private String nombre;
    private String descripcion;
    @Column(name = "precio",nullable = false)
    private Double precio;
    @Column(name = "stock",nullable = false)
    private Integer stock;
    @Column(name = "categoria",nullable = false)
    private String categoria;

}
