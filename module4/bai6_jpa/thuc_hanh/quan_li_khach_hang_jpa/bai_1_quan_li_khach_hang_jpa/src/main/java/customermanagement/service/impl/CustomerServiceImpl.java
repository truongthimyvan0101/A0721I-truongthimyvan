package customermanagement.service.impl;

import customermanagement.model.Customer;
import customermanagement.repository.CustomerRepository;
import customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }
}
