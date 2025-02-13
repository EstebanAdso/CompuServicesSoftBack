package com.example.compuservicessoft.services;

import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.respositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    // Método para listar productos excluyendo categorías
    public Page<Producto> findAllExcludingCategories(List<Long> excludedCategoryIds, Pageable pageable) {
        return productoRepository.findByCategoriaIdNotIn(excludedCategoryIds, pageable);
    }

    // Método para listar productos por categoría excluyendo categorías
    public Page<Producto> findByCategoriaIdExcludingCategories(
            Long categoriaId,
            List<Long> excludedCategoryIds,
            Pageable pageable
    ) {
        return productoRepository.findByCategoriaIdAndCategoriaIdNotIn(categoriaId, excludedCategoryIds, pageable);
    }

    public Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable) {
        return productoRepository.findByCategoriaId(categoriaId, pageable);
    }

    public Page<Producto> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    public Optional<Producto> findById(long id) {
        return productoRepository.findById(id);
    }

    public Page<Producto> findByCategoriaNombre(String categoriaNombre, Pageable pageable) {
        return productoRepository.findByCategoriaNombre(categoriaNombre, pageable);
    }

    public List<Producto> findAllByCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public List<Producto> findAllByCategoriaNombre(String categoriaNombre) {
        return productoRepository.findByCategoriaNombre(categoriaNombre);
    }
}