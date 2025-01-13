package com.example.compuservicessoft.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  Integer cantidad;
    private String nombre;
    private float precioVendido;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private float total;
    private String imagen;
    @Column(length = 6000)
    private String descripcion;
    private String estado;
}
