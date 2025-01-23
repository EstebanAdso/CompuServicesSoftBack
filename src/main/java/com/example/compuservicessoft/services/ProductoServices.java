package com.example.compuservicessoft.services;

import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.respositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener productos por categoría
    public List<Producto> findByCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findByCategoriaNombre(String categoriaNombre){
        return productoRepository.findByCategoriaNombre(categoriaNombre);
    }
}
