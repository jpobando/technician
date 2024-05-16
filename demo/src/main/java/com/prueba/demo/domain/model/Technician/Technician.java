package com.prueba.demo.domain.model.Technician;

public class Technician {
    private final TechnicianId technicianId;
    private final Name name;

    public Technician(TechnicianId technicianId, Name name) {
        this.technicianId = technicianId;
        this.name = name;
    }

    public TechnicianId getTechnicianId() {
        return technicianId;
    }

    public Name getName() {
        return name;
    }
}
