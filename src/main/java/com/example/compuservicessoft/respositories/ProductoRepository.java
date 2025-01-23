package com.example.compuservicessoft.respositories;

import com.example.compuservicessoft.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Método para obtener productos por categoriaId
    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByCategoriaNombre(String categoriaNombre);
}
