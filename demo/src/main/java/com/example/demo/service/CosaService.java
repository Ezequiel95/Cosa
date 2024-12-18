package com.example.demo.service;

import com.example.demo.controller.dto.CosaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CosaService {
    CosaDTO getCosa(Long id);
    CosaDTO setCosa (CosaDTO cosa);
    void deleteCosa(Long id);

    List<CosaDTO> getCosasPorPropietario(Long propietario);
}
