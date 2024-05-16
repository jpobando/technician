package com.prueba.demo.domain.model.Service;

public class Service {
    private final ServiceId serviceId;
    private final Address address;
    private final Description description;
    private final DateTimeInit dateTimeInit;
    private final DateTimeEnd dateTimeEnd;
    private final ServiceTechnicianId serviceTechnicianId;

    public Service(ServiceId serviceId, Address address, Description description, DateTimeInit dateTimeInit, DateTimeEnd dateTimeEnd, ServiceTechnicianId serviceTechnicianId) {
        this.serviceId = serviceId;
        this.address = address;
        this.description = description;
        this.dateTimeInit = dateTimeInit;
        this.dateTimeEnd = dateTimeEnd;
        this.serviceTechnicianId = serviceTechnicianId;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Address getAddress() {
        return address;
    }

    public Description getDescription() {
        return description;
    }

    public DateTimeInit getDateTimeInit() {
        return dateTimeInit;
    }

    public DateTimeEnd getDateTimeEnd() {
        return dateTimeEnd;
    }

    public ServiceTechnicianId getServiceTechnicianId() {
        return serviceTechnicianId;
    }
}
