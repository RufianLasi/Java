package com.example.ms_carrito.Repository;

import com.example.ms_carrito.Entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito,Integer> {
}
