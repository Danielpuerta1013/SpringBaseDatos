package com.example.Store.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoPrenda")
public class TipoPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipoPrenda;
    @Column(name = "nombre",nullable = false, length = 80)
    private String nombre; // no vacio solo letras y espacios y longitud 80

    public TipoPrenda() {
    }

    public TipoPrenda(Integer id, String nombre) {
        this.id_tipoPrenda = id;
        this.nombre = nombre;
    }

    public Integer getId_tipoPrenda() {
        return id_tipoPrenda;
    }

    public void setId_tipoPrenda(Integer id_tipoPrenda) {
        this.id_tipoPrenda = id_tipoPrenda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
