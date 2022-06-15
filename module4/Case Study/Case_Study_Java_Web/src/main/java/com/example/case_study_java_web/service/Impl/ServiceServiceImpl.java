package com.example.case_study_java_web.service.Impl;

import com.example.case_study_java_web.service.ServiceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Override
    public Page<com.example.case_study_java_web.model.Service> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void saveService(com.example.case_study_java_web.model.Service service) {

    }

    @Override
    public void deleteService(Long id) {

    }

    @Override
    public Optional<com.example.case_study_java_web.model.Service> findServiceById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<com.example.case_study_java_web.model.Service> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }
}
