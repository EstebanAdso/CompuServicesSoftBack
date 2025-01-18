package com.example.compuservicessoft.services;

import com.example.compuservicessoft.entities.Categoria;
import com.example.compuservicessoft.respositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(long id) {
        return categoriaRepository.findById(id);
    }
}
