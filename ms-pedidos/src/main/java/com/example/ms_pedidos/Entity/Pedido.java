package com.example.ms_pedidos.Entity;

import com.example.ms_pedidos.enums.EstadoPedido;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero_pedido", nullable = false)
    private Integer numPedido;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado;
    @Column(name = "total",nullable = false)
    private Double total;

}
