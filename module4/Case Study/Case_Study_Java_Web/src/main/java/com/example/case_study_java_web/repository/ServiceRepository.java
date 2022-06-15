package com.example.case_study_java_web.repository;

import com.example.case_study_java_web.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
  Page<Service> findALL (Pageable pageable);
  Page<Service> findAllByNameContaining (String name, Pageable pageable);
}
