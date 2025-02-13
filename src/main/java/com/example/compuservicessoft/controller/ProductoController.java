package com.example.compuservicessoft.controller;

import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    private static final Logger logger = Logger.getLogger(ProductoController.class.getName());

    // Lista de categorías excluidas
    private static final List<Long> CATEGORIAS_EXCLUIDAS = Arrays.asList(7L, 9L, 13L, 24L, 25L, 26L, 29L, 30L, 32L, 33L);

    @GetMapping("/categoria/{valor}")
    public ResponseEntity<Page<Producto>> obtenerProductosPorCategoria(
            @PathVariable String valor,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {

        logger.info("Categoría seleccionada: " + valor + " | Página: " + page);
        Pageable pageable = PageRequest.of(page, size);

        try {
            Long categoriaId = Long.parseLong(valor);
            Page<Producto> productos = productoServices.findByCategoriaId(categoriaId, pageable);
            return ResponseEntity.ok(productos);
        } catch (NumberFormatException e) {
            Page<Producto> productos = productoServices.findByCategoriaNombre(valor, pageable);
            return ResponseEntity.ok(productos);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Producto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort[0]));

        logger.info("Listando productos - Página: " + page + " Tamaño: " + size);
        // Usar el nuevo método para excluir categorías
        Page<Producto> productos = productoServices.findAllExcludingCategories(CATEGORIAS_EXCLUIDAS, pageable);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("{id}")
    public Optional<Producto> buscar(@PathVariable Long id) {
        logger.info("Buscando producto con ID: " + id);
        return productoServices.findById(id);
    }
}