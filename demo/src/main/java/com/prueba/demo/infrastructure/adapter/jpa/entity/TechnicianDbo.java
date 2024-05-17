package com.prueba.demo.infrastructure.adapter.jpa.entity;


import com.prueba.demo.domain.model.Technician.Name;
import com.prueba.demo.domain.model.Technician.Technician;
import com.prueba.demo.domain.model.Technician.TechnicianId;
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
@Table(name = "tbl_technician", schema = "public")
public class TechnicianDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer technicianId;
    private String name;

    public static Technician toDomain(TechnicianDbo technicianDbo) {
        return new Technician(
                new TechnicianId(technicianDbo.getTechnicianId()),
                new Name(technicianDbo.getName())
        );
    }

    public static TechnicianDbo fromDomain(Technician technician) {
        return new TechnicianDbo(
                technician.getTechnicianId().getValue(),
                technician.getName().getValue()
        );
    }
}
