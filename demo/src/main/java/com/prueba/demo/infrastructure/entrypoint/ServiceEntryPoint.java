package com.prueba.demo.infrastructure.entrypoint;

import ch.qos.logback.core.Context;
import com.prueba.demo.domain.usecase.ServiceUseCase;
import com.prueba.demo.infrastructure.entrypoint.dto.ResponseDto;
import com.prueba.demo.infrastructure.entrypoint.dto.ServiceDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class ServiceEntryPoint {
    private final ServiceUseCase serviceUseCase;
    private static final Logger logger = LogManager.getLogger(ServiceEntryPoint.class);

    @PostMapping
    public ResponseEntity<?> saveService(@RequestBody @Valid ServiceDto serviceDto) {
        ResponseDto<?> responseDto = ResponseDto.builder()
                .data(ServiceDto.fromDomain(serviceUseCase.saveService(ServiceDto.toDomain(serviceDto))))
                .status(HttpStatus.OK.value())
                .message("Servicio creado")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        List<ServiceDto> serviceDtoList = serviceUseCase.getAllServices().stream().map(ServiceDto::fromDomain).toList();
        ResponseDto<?> responseDto = ResponseDto.builder()
                .data(serviceDtoList)
                .status(HttpStatus.OK.value())
                .message("Respuesta exitosa")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Integer id) {
        ResponseDto<?> responseDto = ResponseDto.builder()
                .data(ServiceDto.fromDomain(serviceUseCase.getServiceById(id)))
                .status(HttpStatus.OK.value())
                .message("Servicio creado")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
