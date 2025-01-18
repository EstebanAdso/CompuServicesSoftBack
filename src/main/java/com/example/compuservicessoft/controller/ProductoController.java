package com.example.compuservicessoft.controller;

import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    // Endpoint para obtener todos los productos filtrados por categoría
    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable Long categoriaId) {
        return productoServices.findByCategoriaId(categoriaId);
    }

    @GetMapping
    public List<Producto> listar() {
        return productoServices.findAll();
    }

    @GetMapping("{id}")
    public Optional<Producto> buscar(@PathVariable Long id) {
        return productoServices.findById(id);
    }

}
