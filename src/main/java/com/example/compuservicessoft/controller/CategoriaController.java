package com.example.compuservicessoft.controller;

import com.example.compuservicessoft.entities.Categoria;
import com.example.compuservicessoft.entities.Producto;
import com.example.compuservicessoft.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServices categoriaServices;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaServices.findAll();
    }

    @GetMapping("{id}")
    public Optional<Categoria> buscar(@PathVariable Long id) {
        return categoriaServices.findById(id);
    }
}
