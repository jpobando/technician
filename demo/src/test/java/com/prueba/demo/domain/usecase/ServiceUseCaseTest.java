package com.prueba.demo.domain.usecase;

import com.prueba.demo.domain.model.Service.*;
import com.prueba.demo.domain.usecase.gateway.IServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ServiceUseCaseTest {

    @Mock
    private IServiceRepository iServiceRepository;

    @InjectMocks
    private ServiceUseCase serviceUseCase;

    @Test
    void testSaveServiceSuccessful(){
        Service service = new Service(
                new ServiceId(1),
                new Address("Los Molinos"),
                new Description("Básico"),
                new DateTimeInit("01/02/2024 10:00am"),
                new DateTimeEnd("01/02/2024 11:00am"),
                new ServiceTechnicianId(1)
        );
        when(iServiceRepository.saveService(any())).thenReturn(service);
        Service serviceResponse = serviceUseCase.saveService(service);

        verify(iServiceRepository, times(1)).saveService(any());
        assertNotNull(serviceResponse, "Response should not be null");
        assertEquals(serviceResponse.getAddress(), service.getAddress(), "Address should be Los Molinos");
    }

    @Test
    void testGetAllServicesSuccessful(){
        Service service = new Service(
                new ServiceId(1),
                new Address("Los Molinos"),
                new Description("Básico"),
                new DateTimeInit("01/02/2024 10:00am"),
                new DateTimeEnd("01/02/2024 11:00am"),
                new ServiceTechnicianId(1)
        );
        when(iServiceRepository.getAllServices()).thenReturn(List.of(service));
        List<Service> serviceResponse = serviceUseCase.getAllServices();

        verify(iServiceRepository, times(1)).getAllServices();
        assertNotNull(serviceResponse, "Response should not be null");
        assertEquals(serviceResponse.get(0).getAddress(), service.getAddress(), "Address for the first element should be Los Molinos");
    }
}