package com.prueba.demo.infrastructure.entrypoint;

import com.prueba.demo.domain.usecase.TechnicianUseCase;
import com.prueba.demo.infrastructure.entrypoint.dto.ResponseDto;
import com.prueba.demo.infrastructure.entrypoint.dto.TechnicianDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technician")
@AllArgsConstructor
public class TechnicianEntryPoint {
    private final TechnicianUseCase technicianUseCase;

    @PostMapping
    public ResponseEntity<?> saveTechnician(@RequestBody TechnicianDto technicianDto){
        ResponseDto<?> responseDto = ResponseDto.builder()
                .data(TechnicianDto.fromDomain(technicianUseCase.saveTechnician(TechnicianDto.toDomain(technicianDto))))
                .status(HttpStatus.OK.value())
                .message("Técnico registrado")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
