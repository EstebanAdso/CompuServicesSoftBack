package com.example.compuservicessoft.respositories;

import com.example.compuservicessoft.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c WHERE c.id NOT IN :excludedCategoryIds")
    List<Categoria> findByIdNotIn(@Param("excludedCategoryIds") List<Long> excludedCategoryIds);
}