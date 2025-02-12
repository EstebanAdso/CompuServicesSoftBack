package com.example.compuservicessoft.controller;

import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    private static final Logger logger = Logger.getLogger(ProductoController.class.getName());

    @GetMapping("/categoria/{valor}")
    public ResponseEntity<List<Producto>> obtenerProductosPorCategoria(@PathVariable String valor) {
        try {
            Long categoriaId = Long.parseLong(valor);
            logger.info("Categoría seleccionada por ID: " + categoriaId);
            List<Producto> productos = productoServices.findByCategoriaId(categoriaId);
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productos);
        } catch (NumberFormatException e) {
            logger.info("Categoría seleccionada por Nombre: " + valor);
            List<Producto> productos = productoServices.findByCategoriaNombre(valor);
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productos);
        }
    }

    @GetMapping
    public List<Producto> listar() {
        logger.info("Listando todos los productos");
        return productoServices.findAll();
    }

    @GetMapping("{id}")
    public Optional<Producto> buscar(@PathVariable Long id) {
        logger.info("Buscando producto con ID: " + id);
        return productoServices.findById(id);
    }
}
