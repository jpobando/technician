package com.prueba.demo.infrastructure.entrypoint.dto;


import com.prueba.demo.domain.model.Service.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ServiceDto {
    private Integer serviceId;
    @NotNull(message = "La dirección no puede estar vacía")
    @Size(max = 30, message = "La dirección no puede superar 30 caracteres")
    private String address;
    @NotNull(message = "La descripción no puede estar vacía")
    @Size(max = 100, message = "La dirección no puede superar 100 caracteres")
    private String description;
    @NotNull(message = "La fecha de inicio no puede estar vacía")
    private String dateTimeInit;
    @NotNull(message = "La fecha de finalización no puede estar vacía")
    private String dateTimeEnd;
    @NotNull(message = "Debe tener un técnico asociado")
    private Integer serviceTechnicianId;

    public static Service toDomain(ServiceDto serviceDto){
        return new Service(
                new ServiceId(serviceDto.getServiceId()),
                new Address(serviceDto.getAddress()),
                new Description(serviceDto.getDescription()),
                new DateTimeInit(serviceDto.getDateTimeInit()),
                new DateTimeEnd(serviceDto.getDateTimeEnd()),
                new ServiceTechnicianId(serviceDto.getServiceTechnicianId())
        );
    }

    public static ServiceDto fromDomain(Service service){
        return new ServiceDto(
                service.getServiceId().getValue(),
                service.getAddress().getValue(),
                service.getDescription().getValue(),
                service.getDateTimeInit().getValue(),
                service.getDateTimeEnd().getValue(),
                service.getServiceTechnicianId().getValue()
        );
    }
}


