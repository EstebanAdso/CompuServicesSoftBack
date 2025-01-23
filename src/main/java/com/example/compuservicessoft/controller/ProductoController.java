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

    @GetMapping("/categoria/{valor}")
    public ResponseEntity<List<Producto>> obtenerProductosPorCategoria(@PathVariable String valor) {
        try {
            Long categoriaId = Long.parseLong(valor);
            List<Producto> productos = productoServices.findByCategoriaId(categoriaId);
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productos);
        } catch (NumberFormatException e) {
            List<Producto> productos = productoServices.findByCategoriaNombre(valor);
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productos);
        }
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
