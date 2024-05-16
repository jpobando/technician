package com.prueba.demo.infrastructure.entrypoint.dto;

import com.prueba.demo.domain.model.Technician.Name;
import com.prueba.demo.domain.model.Technician.Technician;
import com.prueba.demo.domain.model.Technician.TechnicianId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TechnicianDto {
    private Integer technicianId;
    private String name;

    public static Technician toDomain(TechnicianDto technicianDto){
        return new Technician(
                new TechnicianId(technicianDto.getTechnicianId()),
                new Name(technicianDto.getName())

        );
    }

    public static TechnicianDto fromDomain(Technician technician){
        return new TechnicianDto(
                technician.getTechnicianId().getValue(),
                technician.getName().getValue()
        );
    }
}
