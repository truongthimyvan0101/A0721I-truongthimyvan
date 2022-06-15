package com.example.case_study_java_web.service;

import com.example.case_study_java_web.model.CustomerType;
import com.example.case_study_java_web.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    void saveServiceType (ServiceType serviceType);
    void deleteServiceType(Long id);
    CustomerType findServiceTypeById(Long id);
}
