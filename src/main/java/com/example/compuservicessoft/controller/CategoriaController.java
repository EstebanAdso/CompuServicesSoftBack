package com.example.compuservicessoft.controller;

import com.example.compuservicessoft.entities.Categoria;
import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServices categoriaServices;

    // Lista de categorías excluidas
    private static final List<Long> CATEGORIAS_EXCLUIDAS = Arrays.asList(7L, 9L, 13L, 24L, 25L, 26L, 29L, 30L, 32L, 33L);

    @GetMapping
    public List<Categoria> listar() {
        // Excluir categorías no deseadas al listar todas las categorías
        return categoriaServices.findAllExcludingCategories(CATEGORIAS_EXCLUIDAS);
    }

    @GetMapping("{id}")
    public Optional<Categoria> buscar(@PathVariable Long id) {
        return categoriaServices.findById(id);
    }
}