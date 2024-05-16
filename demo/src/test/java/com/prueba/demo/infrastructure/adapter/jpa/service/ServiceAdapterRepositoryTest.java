package com.prueba.demo.infrastructure.adapter.jpa.service;

import com.prueba.demo.domain.model.Service.*;
import com.prueba.demo.infrastructure.adapter.jpa.technician.ITechnicianAdapterRepository;
import com.prueba.demo.infrastructure.entrypoint.exceptionhandler.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ServiceAdapterRepositoryTest {
    @Mock
    private  IServiceAdapterRepository iServiceAdapterRepository;

    @Mock
    private ITechnicianAdapterRepository iTechnicianAdapterRepository;

    @InjectMocks
    private ServiceAdapterRepository serviceAdapterRepository;

    @Test
    void saveServiceThrowsException() {

        Service service = new Service(
                new ServiceId(1),
                new Address("Los Molinos"),
                new Description("Básico"),
                new DateTimeInit("01/02/2024 10:00am"),
                new DateTimeEnd("01/02/2024 11:00am"),
                new ServiceTechnicianId(1)
        );
        when(iTechnicianAdapterRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class,
                ()-> serviceAdapterRepository.saveService(service));
    }

    @Test
    void saveServiceSuccessful() {

        Service service = new Service(
                new ServiceId(1),
                new Address("Los Molinos"),
                new Description("Básico"),
                new DateTimeInit("01/02/2024 10:00am"),
                new DateTimeEnd("01/02/2024 11:00am"),
                new ServiceTechnicianId(1)
        );
        when(iTechnicianAdapterRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BusinessException.class,
                ()-> serviceAdapterRepository.saveService(service));
    }



}