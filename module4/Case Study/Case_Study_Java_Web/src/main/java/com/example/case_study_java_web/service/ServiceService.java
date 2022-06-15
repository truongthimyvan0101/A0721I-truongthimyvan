package com.example.case_study_java_web.service;

import com.example.case_study_java_web.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    void saveService (Service service);

    void deleteService(Long id);

    Optional<Service> findServiceById(Long id);


    Page<Service> findAllByNameContaining(String name, Pageable pageable);

}
