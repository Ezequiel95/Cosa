package com.example.demo.service;

import com.example.demo.controller.dto.PersonaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "persona-service", url = "http://localhost:8081")
public interface PersonaClient {


    @GetMapping("/api/personas/{id}")
    PersonaDTO getPersonaById(@RequestParam("id") Long idPersona);
}