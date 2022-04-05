package com.codegym.case_study_java_web.Repository;

import com.codegym.case_study_java_web.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Page<Service> findAll (Pageable pageable);
    Page<Service> findAllByNameContaining(String name, Pageable pageable);
}
