package com.codegym.baithi.service.Impl;
import com.codegym.baithi.model.CustomerType;
import com.codegym.baithi.repository.ICustomerTypeRepository;
import com.codegym.baithi.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
