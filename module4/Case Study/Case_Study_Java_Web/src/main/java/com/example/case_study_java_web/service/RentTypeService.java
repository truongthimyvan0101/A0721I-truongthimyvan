package com.example.case_study_java_web.service;

import com.example.case_study_java_web.model.CustomerType;
import com.example.case_study_java_web.model.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    void saveRentType(RentType rentType);
    void deleteRentType(Long id);
    CustomerType findRentTypeById(Long id);
}
