package com.codegym.baithi.repository;

import com.codegym.baithi.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from Customer where customer_name like %?1%", nativeQuery = true)
    Page<Customer> searchCustomerByName(String name, Pageable pageable);
}
