package com.prueba.demo.domain.usecase;

import com.prueba.demo.domain.model.Service.Service;
import com.prueba.demo.domain.usecase.gateway.IServiceRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceUseCase {
    private final IServiceRepository serviceRepository;

    public ServiceUseCase(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service saveService(Service service){
        return serviceRepository.saveService(service);
    }

    public List<Service> getAllServices(){
        return serviceRepository.getAllServices();
    }

    public Service getServiceById(Integer id){
        return serviceRepository.getServiceById(id);
    }
}
