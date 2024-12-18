package com.example.demo.service;

import com.example.demo.controller.dto.CosaDTO;
import com.example.demo.controller.dto.PersonaDTO;
import com.example.demo.repository.CosaRepository;
import com.example.demo.repository.model.Cosa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosasServiceImp implements CosaService {

    private CosaRepository cosaRepository;
    private PersonaClient personaClient;  // Inyección del Feign Client

    @Autowired
    public CosasServiceImp(CosaRepository cosaRepository, @Lazy PersonaClient personaClient) {
        this.cosaRepository = cosaRepository;
        this.personaClient = personaClient;
    }


    @Override
    public List<CosaDTO> getCosasPorPropietario(Long propietario) {
        // 1. Obtener los detalles de la persona (propietario) usando Feign
        PersonaDTO personaDTO = personaClient.getPersonaById(propietario);

        // 2. Verificamos si encontramos la persona
        if (personaDTO == null) {
            // Si no encontramos la persona, devolvemos una lista vacía
            return List.of();
        }

        // 3. Obtener las cosas asociadas al propietario (en MySQL)
        List<Cosa> cosas = cosaRepository.findByPropietario(propietario);

        // 4. Convertimos las cosas a CosaDTO y las retornamos
        return cosas.stream()
                .map(Cosa -> new CosaDTO(Cosa.getIdCosa(), personaDTO))  // Aquí usamos la personaDTO obtenida de Feign
                .collect(Collectors.toList());
    }
//    public CosaDTO getCosa(Long id) {
//        CosaDTO cosa = toDTO(cosaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cosa not found")));
//        PersonaDTO persona = personaClient.getPersonaById(cosa.getPropietario());
//        cosa.setPersonaDTO(persona);
//        return cosa;
//    }


    @Override
    public CosaDTO getCosa(Long id) {
        return null;
    }

    @Override
    public CosaDTO setCosa(CosaDTO cosaDTO) {
        // Convertir el DTO a entidad Cosa
        Cosa cosa = new Cosa();
        cosa.setTipo(cosaDTO.getTipo());
        cosa.setNombre(cosaDTO.getNombre());
        cosa.setDescripcion(cosaDTO.getDescripcion());
        cosa.setPropietario(cosaDTO.getPropietario());
        cosa.setStatus(cosaDTO.getStatus());

        // Guardar la entidad en la base de datos
        Cosa savedCosa = cosaRepository.save(cosa);

        // Convertir la entidad guardada nuevamente a DTO y devolver
        return toDTO(savedCosa);
    }


    @Override
    public void deleteCosa(Long id) {cosaRepository.deleteById(id);}


    private Cosa toEntity(CosaDTO dto) {
        return new  Cosa(
        );
    }
    private CosaDTO toDTO(Cosa entity) {
        // Usamos el constructor de CosaDTO para inicializar un nuevo objeto con los valores de la entidad
        return new CosaDTO(
                entity.getIdCosa(),         // Asignar idCosa
                entity.getTipo(),           // Asignar tipo
                entity.getNombre(),         // Asignar nombre
                entity.getDescripcion(),    // Asignar descripcion
                entity.getPropietario(),    // Asignar propietario
                entity.getStatus()          // Asignar status
        );
    }
}