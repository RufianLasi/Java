package com.example.ms_carrito.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer productoId;
    @Column(nullable = false)
    private String nombreProducto;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Integer cantidad;
}   