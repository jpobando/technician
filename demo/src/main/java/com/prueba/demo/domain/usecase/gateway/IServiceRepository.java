package com.prueba.demo.domain.usecase.gateway;

import com.prueba.demo.domain.model.Service.Service;

import java.util.List;

public interface IServiceRepository {
    Service saveService(Service service);

    List<Service> getAllServices();
}
