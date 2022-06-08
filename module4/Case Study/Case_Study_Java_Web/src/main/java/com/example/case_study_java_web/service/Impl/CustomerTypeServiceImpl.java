package com.example.case_study_java_web.service.Impl;

import com.example.case_study_java_web.model.CustomerType;
import com.example.case_study_java_web.repository.CustomerTypeRepository;
import com.example.case_study_java_web.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void saveCustomerType(CustomerType customerType) {

    }

    @Override
    public void deleteCustomerType(Long id) {

    }

    @Override
    public CustomerType findCustomerTypeById(Long id) {
        return null;
    }
}
