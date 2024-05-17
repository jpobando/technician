package com.prueba.demo.infrastructure.adapter.jpa.service;

import com.prueba.demo.domain.model.Service.Service;
import com.prueba.demo.domain.usecase.gateway.IServiceRepository;
import com.prueba.demo.infrastructure.adapter.jpa.entity.ServiceDbo;
import com.prueba.demo.infrastructure.adapter.jpa.entity.TechnicianDbo;
import com.prueba.demo.infrastructure.adapter.jpa.technician.ITechnicianAdapterRepository;
import com.prueba.demo.infrastructure.entrypoint.dto.ServiceDto;
import com.prueba.demo.infrastructure.entrypoint.exceptionhandler.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceAdapterRepository implements IServiceRepository {

    private final IServiceAdapterRepository iServiceAdapterRepository;
    private final ITechnicianAdapterRepository iTechnicianAdapterRepository;
    @Override
    public Service saveService(Service service) {
        Optional<TechnicianDbo> technicianDbo = iTechnicianAdapterRepository.
                findById(service.getServiceTechnicianId().getValue());
        if(technicianDbo.isEmpty()){
            throw new BusinessException("No se encuentra registrado el técnico");
        }
        ServiceDbo serviceToSave = ServiceDbo.builder()
                .address(service.getAddress().getValue())
                .description(service.getDescription().getValue())
                .dateTimeInit(service.getDateTimeInit().getValue())
                .dateTimeEnd(service.getDateTimeEnd().getValue())
                .technicianDbo(technicianDbo.get())
                .build();

        return ServiceDbo.toDomain(iServiceAdapterRepository.save(serviceToSave));
    }

    @Override
    public Service getServiceById(Integer id) {
        Optional<ServiceDbo> serviceDbo = iServiceAdapterRepository.findById(id);
        if(serviceDbo.isEmpty()){
            throw new BusinessException("No se encuentra registrado el servicio");
        }
        return ServiceDbo.toDomain(serviceDbo.get());
    }

    @Override
    public List<Service> getAllServices() {
        return iServiceAdapterRepository.findAll().stream().map(ServiceDbo::toDomain).toList();
    }
}
