package com.codegym.case_study_java_web.service;

import com.codegym.case_study_java_web.model.RentType;
import com.codegym.case_study_java_web.model.Service;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    void saveRentType (RentType rentType);
    void deleteRentType(Long id);
    RentType findRentTypeById(Long id);
}
