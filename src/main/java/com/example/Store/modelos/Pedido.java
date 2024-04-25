package com.example.Store.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @Column(name = "fechaYHora",nullable = false)
    private LocalDate fechaYHora; // no vacio y formato internacional


    //Creando relaciones entre tablas
    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    Usuario usuario;

    public Pedido(Integer id_pedido, LocalDate fechaYHora, Usuario usuario) {
        this.id_pedido = id_pedido;
        this.fechaYHora = fechaYHora;
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
