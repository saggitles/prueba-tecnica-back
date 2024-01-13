package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombreProducto;
    private String caracteristicas;
    private String precio;
    private String empresa;

    @OneToMany
    private List<Categorias> categorias;
}