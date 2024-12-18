package com.example.demo.repository.model;


import jakarta.persistence.*;

@Entity
@Table( name="cosa", indexes = {
        @Index(name = "idx_propietario_1", columnList = "propietario, tipo"),
        @Index (name = "idx_propietario_2", columnList = "propietario, status")
})

public class Cosa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCosa")  // Nombre de la columna 'id_cosa' en la base de datos
    private Long  idCosa;

    @Column(name = "tipo", nullable = false, length = 50)  // Mapeo de la columna 'tipo'
    private String tipo;

    @Column(name = "nombre", nullable = false, length = 100)  // Mapeo de la columna 'nombre'
    private String nombre;

    @Column(name = "descripcion", length = 255)  // Mapeo de la columna 'descripcion'
    private String descripcion;

    @Column(name = "propietario")  // Mapeo de la columna 'propietario'
    private Long propietario;

    @Column(name = "status", length = 20)  // Mapeo de la columna 'status'
    private String status;




    public Cosa() {
        this.idCosa = idCosa;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.status = status;
    }



    public Long getIdCosa() {
        return idCosa;
    }

    public void setIdCosa(Long idCosa) {
        this.idCosa = idCosa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPropietario() {
        return propietario;
    }

    public void setPropietario(Long propietario) {
        this.propietario = propietario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
