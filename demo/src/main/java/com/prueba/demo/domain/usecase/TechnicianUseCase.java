package com.prueba.demo.domain.usecase;

import com.prueba.demo.domain.model.Technician.Technician;
import com.prueba.demo.domain.usecase.gateway.ITechnicianRepository;
import org.springframework.stereotype.Component;

@Component
public class TechnicianUseCase {
    private final ITechnicianRepository technicianRepository;

    public TechnicianUseCase(ITechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public Technician saveTechnician(Technician technician){
        return technicianRepository.saveTechnician(technician);
    }
}
