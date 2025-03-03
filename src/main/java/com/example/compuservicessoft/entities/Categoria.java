package com.example.compuservicessoft.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @Column(length = 6000)
    private String descripcion;
    @Column(length = 6000)
    private String descripcionGarantia;
}
