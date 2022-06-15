package com.example.case_study_java_web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
public String name;
@OneToMany(mappedBy = "id")
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Long id, String name, Set<Service> services) {
        this.id = id;
        this.name = name;
        this.services = services;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
