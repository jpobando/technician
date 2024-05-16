package com.prueba.demo.infrastructure.adapter.jpa.service;

import com.prueba.demo.infrastructure.adapter.jpa.entity.ServiceDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceAdapterRepository extends JpaRepository<ServiceDbo, Integer> {
}
