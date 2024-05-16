package com.prueba.demo.infrastructure.adapter.jpa.technician;

import com.prueba.demo.infrastructure.adapter.jpa.entity.TechnicianDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnicianAdapterRepository extends JpaRepository<TechnicianDbo, Integer> {
}
