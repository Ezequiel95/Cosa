package com.example.demo.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Asegura que haya un constructor sin parámetros
@AllArgsConstructor
public class CosaDTO {
    private Long idCosa;
    private String tipo;
    private String nombre;
    private String descripcion;
    private Long propietario;
    private String status;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaDTO personaDTO;

    public CosaDTO(Long idCosa, PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }



    public CosaDTO(Long idCosa, String tipo, String nombre, String descripcion, Long propietario, String status) {
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

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }
}
