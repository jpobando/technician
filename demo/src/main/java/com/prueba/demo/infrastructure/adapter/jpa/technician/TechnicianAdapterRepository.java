package com.prueba.demo.infrastructure.adapter.jpa.technician;

import com.prueba.demo.domain.model.Technician.Technician;
import com.prueba.demo.domain.usecase.gateway.ITechnicianRepository;
import com.prueba.demo.infrastructure.adapter.jpa.entity.TechnicianDbo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TechnicianAdapterRepository implements ITechnicianRepository {

    private final ITechnicianAdapterRepository iTechnicianAdapterRepository;

    @Override
    public Technician saveTechnician(Technician technician) {
        TechnicianDbo technicianSaved = iTechnicianAdapterRepository.save(TechnicianDbo.fromDomain(technician));
        return TechnicianDbo.toDomain(technicianSaved);
    }
}
