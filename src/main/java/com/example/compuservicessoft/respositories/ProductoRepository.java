package com.example.compuservicessoft.respositories;

import com.example.compuservicessoft.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Page<Producto> findAll(Pageable pageable);
    Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable);
    Page<Producto> findByCategoriaNombre(String categoriaNombre, Pageable pageable);

    // Método para excluir categorías al listar productos
    @Query("SELECT p FROM Producto p WHERE p.categoria.id NOT IN :excludedCategoryIds")
    Page<Producto> findByCategoriaIdNotIn(@Param("excludedCategoryIds") List<Long> excludedCategoryIds, Pageable pageable);

    // Método para excluir categorías al listar productos por categoría
    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :categoriaId AND p.categoria.id NOT IN :excludedCategoryIds")
    Page<Producto> findByCategoriaIdAndCategoriaIdNotIn(
            @Param("categoriaId") Long categoriaId,
            @Param("excludedCategoryIds") List<Long> excludedCategoryIds,
            Pageable pageable
    );

    List<Producto> findByCategoriaId(Long categoriaId);
    List<Producto> findByCategoriaNombre(String categoriaNombre);
}