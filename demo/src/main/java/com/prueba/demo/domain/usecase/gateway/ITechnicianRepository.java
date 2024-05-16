package com.prueba.demo.domain.usecase.gateway;

import com.prueba.demo.domain.model.Technician.Technician;

public interface ITechnicianRepository {

    Technician saveTechnician(Technician technician);
}
