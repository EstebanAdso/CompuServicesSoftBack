package com.example.compuservicessoft.respositories;

import com.example.compuservicessoft.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Page<Producto> findAll(Pageable pageable);
    Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable);
    Page<Producto> findByCategoriaNombre(String categoriaNombre, Pageable pageable);
}
