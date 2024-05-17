package com.prueba.demo.infrastructure.adapter.jpa.entity;

import com.prueba.demo.domain.model.Service.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "tbl_service", schema = "public")
public class ServiceDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String address;
    private String description;
    private String dateTimeInit;
    private String dateTimeEnd;
    @ManyToOne
    @JoinColumn(name = "technicianId")
    private TechnicianDbo technicianDbo;

    public static Service toDomain(ServiceDbo serviceDbo){
        return new Service(
                new ServiceId(serviceDbo.getServiceId()),
                new Address(serviceDbo.getAddress()),
                new Description(serviceDbo.getDescription()),
                new DateTimeInit(serviceDbo.getDateTimeInit()),
                new DateTimeEnd(serviceDbo.getDateTimeEnd()),
                new ServiceTechnicianId(serviceDbo.getTechnicianDbo().getTechnicianId())
        );
    }

}
