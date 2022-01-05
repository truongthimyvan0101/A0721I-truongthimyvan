package model;
import model.Customer;
import java.util.List;

public class CustomerRepository {
    List<Customer> findAll();

    boolean save(Customer customer);

    Customer findById(int id);

    boolean update(int id, Customer customer);

    boolean remove(int id);
}
